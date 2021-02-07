package spicy.transformers;

import java.util.List;

import spicy.ClassNames;
import spicy.Injector;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

public class ClientTransformer extends Injector {

	
	@Override
    public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>)classNode.methods) {
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.minecraft)) && methodNode.name.equals(ClassNames.runGame)) && methodNode.desc.equals("()V")) {
	            InsnList ifpart = new InsnList();
	            LabelNode returnpart = new LabelNode();
	            ifpart.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/Spicy", "bypassClient", "()Z", false));
				ifpart.add(new JumpInsnNode(IFEQ, returnpart));
                
				InsnList insnList = new InsnList();
                
                insnList.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/Spicy", "start", "()V", false));
                methodNode.instructions.insert(insnList);
                
                AbstractInsnNode abs = null;
                
                for (AbstractInsnNode ain : methodNode.instructions.toArray()) {
                	if (ain.getOpcode() == INVOKESTATIC && ((MethodInsnNode)ain).name.equals("start")) {
                		abs = ain;
                	}
                }
                
                methodNode.instructions.insertBefore(abs, ifpart);
                methodNode.instructions.insert(abs, returnpart);
            }
			if ((methodNode.name.equals(ClassNames.runTick) && classNode.name.contains(ClassNames.getNameIndex(ClassNames.minecraft))) && methodNode.desc.equals("()V")) {
            	AbstractInsnNode ain = null;
            	
				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == ISTORE) {
						if (((VarInsnNode) abs).var == 2 && abs.getPrevious().getOpcode() == INVOKESTATIC && abs.getPrevious().getPrevious().getOpcode() == IFEQ && abs.getPrevious().getPrevious().getPrevious().getOpcode() == INVOKESTATIC) {
							ain = abs.getNext();
						}
					}
				}
				
				InsnList insnList = new InsnList();
                insnList.add(new TypeInsnNode(NEW, "xyz/spicy/event/events/MouseEvent"));
            	insnList.add(new InsnNode(DUP));
            	insnList.add(new VarInsnNode(ILOAD, 2));	
            	insnList.add(new MethodInsnNode(INVOKESPECIAL, "xyz/spicy/event/events/MouseEvent", "<init>", "(I)V", false));
            	insnList.add(new MethodInsnNode(INVOKEVIRTUAL, "xyz/spicy/event/events/MouseEvent", "call", "()Lxyz/spicy/event/Event;", false));
            	insnList.add(new InsnNode(POP));
            	methodNode.instructions.insert(ain,insnList);
				
				AbstractInsnNode ain2 = ain;	
				
				for (int i = 0; i < 5; ++i) {
					ain2 = ain2.getNext();	
				}
            	
				InsnList ins = new InsnList();
				LabelNode lb = new LabelNode();
				ins.add(new MethodInsnNode(INVOKESTATIC, "org/lwjgl/input/Mouse", "getEventButtonState", "()Z", false));
				ins.add(new JumpInsnNode(IFEQ,lb));
				
				methodNode.instructions.insert(ain2, lb);
				
				
			}
            if ((methodNode.name.equals(ClassNames.runTick) && classNode.name.contains(ClassNames.getNameIndex(ClassNames.minecraft))) && methodNode.desc.equals("()V")) {// runtick methodu
            	InsnList insnList = new InsnList();
                insnList.add(new VarInsnNode(ALOAD, 0));
                insnList.add(new InsnNode(ICONST_1));
                insnList.add(new FieldInsnNode(PUTFIELD, ClassNames.minecraft, ClassNames.rightclickdelay, "I"));
            	methodNode.instructions.insert(insnList);
            	
            	AbstractInsnNode ainsnList = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == ALOAD) {
	    				if (((VarInsnNode) abs).var == 0 && abs.getNext().getOpcode() == ICONST_1) {
	    					ainsnList = abs;
	    					break;
	    				}
	    			}
	    		}
	    		AbstractInsnNode ifcondi = ainsnList;
	    		
	    		for (int i = 0; i < 2; ++i) {
	    			ifcondi = ifcondi.getNext();
	    		} 

            	
                InsnList insnList1 = new InsnList();
                LabelNode lb = new LabelNode();
                insnList1.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/FastPlace", "isEnabled", "()Z",false));
                insnList1.add(new JumpInsnNode(IFEQ, lb));
               	
                methodNode.instructions.insertBefore(ainsnList, insnList1);
                methodNode.instructions.insert(ifcondi, lb);
            }
			if ((methodNode.name.equals(ClassNames.runTick) && classNode.name.contains(ClassNames.getNameIndex(ClassNames.minecraft))) && methodNode.desc.equals("()V")) {
				
				AbstractInsnNode ain = null;
				
				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == ILOAD) {
						if (abs.getNext().getOpcode() == INVOKESTATIC && abs.getPrevious().getOpcode() == F_NEW && ((VarInsnNode)abs).var == 2) {
							ain = abs.getNext();
						}
					}
				}
				
                InsnList insnList = new InsnList();
                insnList.add(new TypeInsnNode(NEW, "xyz/spicy/event/events/KeyPressEvent"));
            	insnList.add(new InsnNode(DUP));
            	insnList.add(new VarInsnNode(ILOAD, 2));
            	insnList.add(new MethodInsnNode(INVOKESPECIAL, "xyz/spicy/event/events/KeyPressEvent", "<init>", "(I)V", false));
            	insnList.add(new MethodInsnNode(INVOKEVIRTUAL, "xyz/spicy/event/events/KeyPressEvent", "call", "()Lxyz/spicy/event/Event;", false));
            	insnList.add(new InsnNode(POP));
                methodNode.instructions.insert(ain, insnList);
                
				
				AbstractInsnNode ain2 = ain;	
				
				for (int i = 0; i < 5; ++i) {
					ain2 = ain2.getNext();
				}
				
				InsnList ins = new InsnList();
				LabelNode lb = new LabelNode();
				ins.add(new MethodInsnNode(INVOKESTATIC, "org/lwjgl/input/Keyboard", "getEventKeyState", "()Z", false));
				ins.add(new JumpInsnNode(IFEQ,lb));
				
				methodNode.instructions.insert(ain2, lb);
			}
		}
	}
}

