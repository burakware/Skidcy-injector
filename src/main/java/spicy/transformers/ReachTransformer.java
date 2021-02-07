package spicy.transformers;

import java.util.List;

import spicy.ClassNames;
import spicy.Injector;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class ReachTransformer extends Injector {

	@Override
    public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>)classNode.methods) {
			if ((methodNode.name.equals(ClassNames.getMouseOver) && classNode.name.contains(ClassNames.getNameIndex(ClassNames.entityrenderer))) && methodNode.desc.equals("(F)V"))
			{
				AbstractInsnNode zan = null;
				
				for (AbstractInsnNode qwe : methodNode.instructions.toArray()) {
					if (qwe.getOpcode() == ALOAD && qwe.getNext().getOpcode() == GETFIELD && qwe.getNext().getNext().getOpcode() == ALOAD && qwe.getNext().getNext().getNext().getOpcode() == DLOAD && qwe.getNext().getNext().getNext().getNext().getOpcode() == FLOAD && qwe.getNext().getNext().getNext().getNext().getNext().getOpcode() == INVOKEVIRTUAL)
					{
						zan = qwe.getNext().getNext();
						break;
					}
				}
				
				methodNode.instructions.remove(zan.getNext());
				InsnList reach = new InsnList();
				reach.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Reach", "getValue", "()D", false));
				
				methodNode.instructions.insert(zan,  reach);
				
				
				AbstractInsnNode controlremove = null;
				
				for (AbstractInsnNode qwe : methodNode.instructions.toArray()) {
					if 
					(qwe.getOpcode() == F_NEW && qwe.getNext().getOpcode() == ICONST_1) {
						controlremove = qwe;
						break;
					}
				}
				
				methodNode.instructions.remove(controlremove.getNext());
				InsnList controlnext = new InsnList();
				controlnext.add(new InsnNode(ICONST_0));
				methodNode.instructions.insert(controlremove, controlnext);
				AbstractInsnNode zan1 = null;
				AbstractInsnNode zan2 = null;
				AbstractInsnNode zan3 = null;
				for (AbstractInsnNode qwe : methodNode.instructions.toArray()) {
					if (qwe.getOpcode() ==F_NEW && qwe.getNext().getOpcode() == ALOAD && qwe.getNext().getNext().getOpcode() == FLOAD && qwe.getNext().getNext().getNext().getOpcode() == INVOKEVIRTUAL && qwe.getNext().getNext().getNext().getNext().getOpcode() == ASTORE && ((VarInsnNode)qwe.getNext().getNext().getNext().getNext()).var == 11)
					{
						zan1 = qwe.getNext().getNext().getNext().getNext().getNext().getNext().getNext();
						zan2 = zan1.getNext().getNext().getNext().getNext();
						zan3 = zan2.getNext().getNext().getNext().getNext();
						break;
					}
				}
				methodNode.instructions.remove(zan1.getNext());
				methodNode.instructions.remove(zan2.getNext());
				methodNode.instructions.remove(zan3.getNext());
				AbstractInsnNode zan11 = null;

				AbstractInsnNode zan22 = null;

				AbstractInsnNode zan33 = null;
				
				for (AbstractInsnNode qwe : methodNode.instructions.toArray()) {
					if (qwe.getOpcode() ==ALOAD && qwe.getNext().getOpcode() == ALOAD && qwe.getNext().getNext().getOpcode() == INVOKEVIRTUAL && qwe.getNext().getNext().getNext().getOpcode() == ALOAD &&  ((VarInsnNode)qwe.getNext().getNext().getNext()).var == 11 && qwe.getNext().getNext().getNext().getNext().getOpcode() == GETFIELD)
					{
						zan11 = qwe.getNext().getNext().getNext().getNext();
						zan22 = zan11.getNext().getNext().getNext().getNext();
						zan33 = zan22.getNext().getNext().getNext().getNext();
						break;
					}
				}
				
				methodNode.instructions.remove(zan11.getNext());
				methodNode.instructions.remove(zan22.getNext());
				methodNode.instructions.remove(zan33.getNext());
				
				
				InsnList insn1 = new InsnList();
				insn1.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Reach", "getValue", "()D", false));
				methodNode.instructions.insert(zan1, insn1);
				
				InsnList insn2 = new InsnList();
				insn2.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Reach", "getValue", "()D", false));
			
				methodNode.instructions.insert(zan2, insn2);

				InsnList insn3 = new InsnList();
				insn3.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Reach", "getValue", "()D", false));
				methodNode.instructions.insert(zan3, insn3);
				
				
				InsnList insn4 = new InsnList();
				insn4.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Reach", "getValue", "()D", false));
				methodNode.instructions.insert(zan11, insn4);

				InsnList insn5 = new InsnList();
				insn5.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Reach", "getValue", "()D", false));
				methodNode.instructions.insert(zan22, insn5);
				
				InsnList insn6 = new InsnList();
				insn6.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Reach", "getValue", "()D", false));
				methodNode.instructions.insert(zan33, insn6);
			}
		}
	}
	
}
