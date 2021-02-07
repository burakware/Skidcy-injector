package spicy.transformers;


import java.util.List;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import spicy.ClassNames;
import spicy.Injector;

public class ScaffoldTransformer extends Injector {

	boolean one = false;

	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>)classNode.methods) {
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.entity)) && methodNode.name.equals(ClassNames.moveEntity)) && methodNode.desc.equals("(DDD)V")) {
				AbstractInsnNode target2 = null;
				AbstractInsnNode todelete = null;
				for (AbstractInsnNode codes : methodNode.instructions.toArray()) {
					if (codes.getOpcode() == F_NEW && codes.getNext().getOpcode() == ISTORE && ((VarInsnNode)codes.getNext()).var == 20 &&  codes.getNext().getNext().getOpcode() == ILOAD && ((VarInsnNode)codes.getNext().getNext()).var == 20 && codes.getNext().getNext().getNext().getOpcode() == IFEQ) {
						target2 = codes.getNext();
						todelete = codes.getNext().getNext();
						break;
					}
				}

				methodNode.instructions.remove(todelete);

				InsnList insertMove = new InsnList();
				insertMove.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/utils/EntityUtils", "onMove", "()V", false));
				methodNode.instructions.insert(insertMove);

				InsnList toinsert = new InsnList();

				toinsert.add(new VarInsnNode(ALOAD, 0));
				toinsert.add(new FieldInsnNode(GETFIELD, ClassNames.entity, ClassNames.onground, "Z"));
				toinsert.add(new VarInsnNode(ALOAD, 0));
				toinsert.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.entity, ClassNames.isSneaking, "()Z", false));
				toinsert.add(new VarInsnNode(ALOAD, 0));
				toinsert.add(new TypeInsnNode(INSTANCEOF, ClassNames.entityplayersp));
				toinsert.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Scaffold", "checkStats", "(ZZZ)Z", false));

			}
			if ((classNode.name.contains("Scaffold") && methodNode.name.equals("data")) && methodNode.desc.equals("(Lnet/minecraft/BlockPos;III)L" + ClassNames.block + ";")) {
				AbstractInsnNode areturn = null;

				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == ARETURN) {
						areturn = abs;
					}
				}

				methodNode.instructions.remove(areturn.getPrevious());

				InsnList insert = new InsnList();

				insert.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/utils/TransformerHelper", "mc", "()" + ClassNames.getDesc(ClassNames.minecraft), false));
				insert.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.theWorld, ClassNames.getDesc(ClassNames.worldclient)));
				insert.add(new VarInsnNode(ALOAD, 1));
				insert.add(new VarInsnNode(ILOAD, 2));
				insert.add(new VarInsnNode(ILOAD, 3));
				insert.add(new VarInsnNode(ILOAD, 4));
				insert.add(new MethodInsnNode(INVOKEVIRTUAL, "net/minecraft/BlockPos", ClassNames.add, "(III)Lnet/minecraft/BlockPos;", false));
				insert.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.worldclient, ClassNames.getBlockState, "(Lnet/minecraft/BlockPos;)" + ClassNames.getDesc(ClassNames.iblockstate), false));
				insert.add(new MethodInsnNode(INVOKEINTERFACE, ClassNames.iblockstate, ClassNames.getBlock, "()" + ClassNames.getDesc(ClassNames.block), true));
				methodNode.instructions.insertBefore(areturn, insert);
			}
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.entityplayer)) && methodNode.name.equals(ClassNames.getHeldItem)) && methodNode.desc.equals("()" + ClassNames.getDesc(ClassNames.itemstack))) {
				AbstractInsnNode areturn = null;
				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == ALOAD) {
						areturn = abs;
						break;
					}
				}
				InsnList insnList = new InsnList();
				insnList.add(new VarInsnNode(ALOAD, 0));
				insnList.add(new FieldInsnNode(GETFIELD, ClassNames.entityplayer, ClassNames.inventory, ClassNames.getDesc(ClassNames.inventoryplayer)));
				insnList.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.inventoryplayer, ClassNames.getCurrentItem, "()" + ClassNames.getDesc(ClassNames.itemstack), false));
				insnList.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Scaffold", "putfield", "(" + ClassNames.getDesc(ClassNames.itemstack) + ")V", false));
				methodNode.instructions.insertBefore(areturn, insnList);
			}
		}
	}
}
