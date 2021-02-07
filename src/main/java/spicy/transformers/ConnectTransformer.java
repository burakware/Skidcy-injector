package spicy.transformers;

import java.util.List;

import spicy.ClassNames;
import spicy.Injector;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class ConnectTransformer extends Injector {

	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
	    for (MethodNode methodNode : (List<MethodNode>)classNode.methods) {
	    	if ((classNode.name.contains("TransformerHelper") && methodNode.name.equals("mc")) && methodNode.desc.equals("()" + ClassNames.getDesc(ClassNames.minecraft))) {
	    		
	    		AbstractInsnNode areturn = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == ARETURN) {
	    				areturn = abs;
	    			}
	    		}
	    		
	    		methodNode.instructions.remove(areturn.getPrevious());
	    		
	    		InsnList minecraft = new InsnList();
	    		
	    		minecraft.add(new MethodInsnNode(INVOKESTATIC, ClassNames.minecraft, ClassNames.getMinecraft, "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	    		
	    		methodNode.instructions.insertBefore(areturn, minecraft);
	    	}
	    	if ((classNode.name.contains("TransformerHelper") && methodNode.name.equals("packet")) && methodNode.desc.equals("()" + ClassNames.packet + ";")) {
	    		AbstractInsnNode packet = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == RETURN) {
	    				packet = abs;
	    			}
	    		}
	    		
	    		methodNode.instructions.remove(packet.getPrevious());
	    		
	    		InsnList insn = new InsnList();
	    		
	            insn.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/utils/TransformerHelper", "mc", "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	            insn.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.minecraft, ClassNames.getHandleClient, "()" + ClassNames.getDesc(ClassNames.nethandlerplayclient) , false));
	            insn.add(new VarInsnNode(ALOAD, 1));
	            insn.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.nethandlerplayclient, ClassNames.addToSendQueue, "(L" + ClassNames.packet + ";)V", false));
	    	
	            methodNode.instructions.insertBefore(packet, insn);
	    	}
	    	if ((classNode.name.contains("TransformerHelper") && methodNode.name.equals("getNameHelper")) && methodNode.desc.equals("(" + ClassNames.getDesc(ClassNames.entityplayer) + ")Ljava/lang/String;")) {
	    		AbstractInsnNode packet = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == ARETURN) {
	    				packet = abs;
	    			}
	    		}
	    		methodNode.instructions.remove(packet.getPrevious());

	    		
	    		InsnList insn = new InsnList();
	    		
	            insn.add(new VarInsnNode(ALOAD, 0));
	            insn.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.entityplayer, ClassNames.getName, "()Ljava/lang/String;", false));
	            
	            methodNode.instructions.insertBefore(packet, insn);
	    	}
	    	if ((classNode.name.contains("TransformerHelper") && methodNode.name.equals("getDistanceHelper")) && methodNode.desc.equals("(" + ClassNames.getDesc(ClassNames.entityplayer) + ")F")) {
	    		AbstractInsnNode packet = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == FRETURN) {
	    				packet = abs;
	    			}
	    		}
	    		
	    		methodNode.instructions.remove(packet.getPrevious());
	    		
	    		InsnList insn = new InsnList();
	    		
	    		 insn.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/utils/TransformerHelper", "mc", "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	             insn.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.thePlayer, ClassNames.getDesc(ClassNames.entityplayersp)));
	             insn.add(new VarInsnNode(ALOAD, 0));
	             insn.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.entityplayersp, ClassNames.getDistanceToEntity, "(" + ClassNames.getDesc(ClassNames.entity) + ")F", false));

	    	
	            methodNode.instructions.insertBefore(packet, insn);
	    	}
	    	if ((classNode.name.contains("TransformerHelper") && methodNode.name.equals("getEyeHeightHelper")) && methodNode.desc.equals("(" + ClassNames.getDesc(ClassNames.entityplayer) + ")F")) {
	    		AbstractInsnNode packet = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == FRETURN) {
	    				packet = abs;
	    			}
	    		}
	    		
	    		methodNode.instructions.remove(packet.getPrevious());
	    		
	    		InsnList insn = new InsnList();
	    		
	    		insn.add(new VarInsnNode(ALOAD, 0));
	            insn.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.entityplayer, ClassNames.eyeHeight, "()F", false));
	    	
	            methodNode.instructions.insertBefore(packet, insn);
	    	}
	    	if ((classNode.name.contains("TransformerHelper") && methodNode.name.equals("getStackSlotItem")) && methodNode.desc.equals("(I)" + ClassNames.getDesc(ClassNames.itemstack))) {
	    		AbstractInsnNode packet = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == ARETURN) {
	    				packet = abs;
	    			}
	    		}

	    		methodNode.instructions.remove(packet.getPrevious());
	    		
	    		InsnList insn = new InsnList();
	    		
	            insn.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/utils/TransformerHelper", "mc", "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	            insn.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.thePlayer, ClassNames.getDesc(ClassNames.entityplayersp)));
	            insn.add(new FieldInsnNode(GETFIELD, ClassNames.entityplayersp, ClassNames.inventory, ClassNames.getDesc(ClassNames.inventoryplayer)));
	            insn.add(new VarInsnNode(ILOAD, 0));
	            insn.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.inventoryplayer, ClassNames.getStackInSlot, "(I)" + ClassNames.getDesc(ClassNames.itemstack), false));
	    	
	            methodNode.instructions.insertBefore(packet, insn);
	    	}
	    	if ((classNode.name.contains("TransformerHelper") && methodNode.name.equals("getStackSlotItemWithItem")) && methodNode.desc.equals("(I)" + ClassNames.getDesc(ClassNames.item))) {
	    		AbstractInsnNode packet = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == ARETURN) {
	    				packet = abs;
	    			}
	    		}

	    		methodNode.instructions.remove(packet.getPrevious());
	    		
	    		InsnList insn = new InsnList();
	    		
	            insn.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/utils/TransformerHelper", "mc", "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	            insn.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.thePlayer, ClassNames.getDesc(ClassNames.entityplayersp)));
	            insn.add(new FieldInsnNode(GETFIELD, ClassNames.entityplayersp, ClassNames.inventory, ClassNames.getDesc(ClassNames.inventoryplayer)));
	            insn.add(new VarInsnNode(ILOAD, 0));
	            insn.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.inventoryplayer, ClassNames.getStackInSlot, "(I)" + ClassNames.getDesc(ClassNames.itemstack), false));
	            insn.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.itemstack, ClassNames.getItem, "()" + ClassNames.getDesc(ClassNames.item), false));

	    	
	            methodNode.instructions.insertBefore(packet, insn);
	    	}
	    	if ((classNode.name.contains("TransformerHelper") && methodNode.name.equals("setMotY")) && methodNode.desc.equals("(D)V")) {
	    		AbstractInsnNode packet = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == RETURN) {
	    				packet = abs;
	    			}
	    		}
	    		
	    		InsnList insn = new InsnList();
	    		
	            insn.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/utils/TransformerHelper", "mc", "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	            insn.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.thePlayer, ClassNames.getDesc(ClassNames.entityplayersp)));
	            insn.add(new VarInsnNode(DLOAD, 0));
	            insn.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.entityplayersp, "a", "(D)V", false));
	            
	            methodNode.instructions.insertBefore(packet, insn);
	    	}
	    	if ((classNode.name.contains("TransformerHelper") && methodNode.name.equals("isActivePot")) && methodNode.desc.equals("(I)Z")) {
	    		AbstractInsnNode packet = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == ICONST_0) {
	    				packet = abs.getNext();
	    			}
	    		}
	    		
	    		methodNode.instructions.remove(packet.getPrevious());
	    		
	    		InsnList insn = new InsnList();
	    		
	            insn.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/utils/TransformerHelper", "mc", "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	            insn.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.thePlayer, ClassNames.getDesc(ClassNames.entityplayersp)));
	            insn.add(new VarInsnNode(ILOAD, 0));
	            insn.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.entityplayersp, ClassNames.isPotionActive, "(I)Z", false));
	            
	            methodNode.instructions.insertBefore(packet, insn);
	    	}
	    	if ((classNode.name.contains("TransformerHelper") && methodNode.name.equals("getActivePotion")) && methodNode.desc.equals("(" + ClassNames.getDesc(ClassNames.potion) + ")" +  ClassNames.getDesc(ClassNames.potioneffect))) {
	    		AbstractInsnNode packet = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == ARETURN) {
	    				packet = abs;
	    			}
	    		}
	
	    		methodNode.instructions.remove(packet.getPrevious());
	    		
	    		InsnList insn = new InsnList();
	    		
	            insn.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/utils/TransformerHelper", "mc", "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	            insn.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.thePlayer, ClassNames.getDesc(ClassNames.entityplayersp)));
	    		insn.add(new VarInsnNode(ALOAD, 0));
	            insn.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.entityplayersp, ClassNames.getActivePotionEffect, "(" + ClassNames.getDesc(ClassNames.potion) + ")" +  ClassNames.getDesc(ClassNames.potioneffect), false));

	            
	            methodNode.instructions.insertBefore(packet, insn);
	    	}

	    }
	}
}
