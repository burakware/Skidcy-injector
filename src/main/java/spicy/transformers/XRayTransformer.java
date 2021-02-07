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
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class XRayTransformer extends Injector {

	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
	    for (MethodNode methodNode : (List<MethodNode>)classNode.methods) {
	    	if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.block)) && methodNode.name.equals(ClassNames.shouldSideBeRendered)) && methodNode.desc.equals("(L" + ClassNames.iblockaccess + ";Lnet/minecraft/BlockPos;L" + ClassNames.enumfacing + ";)Z")) {
	    	
	    		InsnList insnList = new InsnList();

	    		insnList.add(new MethodInsnNode(INVOKESTATIC, ClassNames.minecraft, ClassNames.getMinecraft, "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	    		insnList.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.mcGameSettings, ClassNames.getDesc(ClassNames.gamesettings)));
	    		insnList.add(new InsnNode(ICONST_0));
	    		insnList.add(new FieldInsnNode(PUTFIELD, ClassNames.gamesettings, ClassNames.ambientOcclusion, "I"));
	    		insnList.add(new InsnNode(ICONST_1));
	    		insnList.add(new InsnNode(IRETURN));
	    		
	    		insnList.add(new MethodInsnNode(INVOKESTATIC, ClassNames.minecraft, ClassNames.getMinecraft, "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	    		insnList.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.mcGameSettings, ClassNames.getDesc(ClassNames.gamesettings)));
	    		insnList.add(new InsnNode(ICONST_0));
	    		insnList.add(new FieldInsnNode(PUTFIELD, ClassNames.gamesettings, ClassNames.ambientOcclusion, "I"));
	    		insnList.add(new InsnNode(ICONST_1));
	    		insnList.add(new InsnNode(IRETURN));
	    		
	    		insnList.add(new MethodInsnNode(INVOKESTATIC, ClassNames.minecraft, ClassNames.getMinecraft, "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	    		insnList.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.mcGameSettings, ClassNames.getDesc(ClassNames.gamesettings)));
	    		insnList.add(new InsnNode(ICONST_0));
	    		insnList.add(new FieldInsnNode(PUTFIELD, ClassNames.gamesettings, ClassNames.ambientOcclusion, "I"));
	    		insnList.add(new InsnNode(ICONST_1));
	    		insnList.add(new InsnNode(IRETURN));
	    		
	    		insnList.add(new MethodInsnNode(INVOKESTATIC, ClassNames.minecraft, ClassNames.getMinecraft, "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	    		insnList.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.mcGameSettings, ClassNames.getDesc(ClassNames.gamesettings)));
	    		insnList.add(new InsnNode(ICONST_0));
	    		insnList.add(new FieldInsnNode(PUTFIELD, ClassNames.gamesettings, ClassNames.ambientOcclusion, "I"));
	    		insnList.add(new InsnNode(ICONST_1));
	    		insnList.add(new InsnNode(IRETURN));
	    		
	    		insnList.add(new MethodInsnNode(INVOKESTATIC, ClassNames.minecraft, ClassNames.getMinecraft, "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	    		insnList.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.mcGameSettings, ClassNames.getDesc(ClassNames.gamesettings)));
	    		insnList.add(new InsnNode(ICONST_0));
	    		insnList.add(new FieldInsnNode(PUTFIELD, ClassNames.gamesettings, ClassNames.ambientOcclusion, "I"));
	    		insnList.add(new InsnNode(ICONST_1));
	    		insnList.add(new InsnNode(IRETURN));
	    		
                insnList.add(new MethodInsnNode(INVOKESTATIC, ClassNames.minecraft, ClassNames.getMinecraft, "()" + ClassNames.getDesc(ClassNames.minecraft), false));
                insnList.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.mcGameSettings, ClassNames.getDesc(ClassNames.gamesettings)));
                insnList.add(new InsnNode(ICONST_1));
                insnList.add(new FieldInsnNode(PUTFIELD, ClassNames.gamesettings, ClassNames.ambientOcclusion, "I"));
                insnList.add(new InsnNode(ICONST_0));
                insnList.add(new InsnNode(IRETURN));
	    		methodNode.instructions.insert(insnList);

	    		AbstractInsnNode ain = null;
	    		AbstractInsnNode ainD = null;
	    		AbstractInsnNode ainE = null;
	    		AbstractInsnNode ainF = null;
	    		AbstractInsnNode ainG = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == INVOKESTATIC) {
	    				if (abs.getNext().getOpcode() == GETFIELD && abs.getNext().getNext().getOpcode() == ICONST_0) {
	    					ain = abs;
	    					ainD = abs.getNext().getNext().getNext().getNext().getNext().getNext();
	    					ainE = ainD.getNext().getNext().getNext().getNext().getNext().getNext();
	    					ainF = ainE.getNext().getNext().getNext().getNext().getNext().getNext();
	    					ainG = ainF.getNext().getNext().getNext().getNext().getNext().getNext();
	    					break;
	    				}
	    			}
	    		}
	    		
	    		AbstractInsnNode ainenable = ain;
	    		
	    		for (int i = 0; i < 5; ++i) {
	    			ainenable = ainenable.getNext();
	    		}
	    		
	    		AbstractInsnNode ainenableD = ainD;
	    		
	    		for (int i = 0; i < 5; ++i) {
	    			ainenableD = ainenableD.getNext();
	    		}
	    		
	    		AbstractInsnNode ainenableE = ainE;
	    		
	    		for (int i = 0; i < 5; ++i) {
	    			ainenableE = ainenableE.getNext();
	    		}
	    		
	    		AbstractInsnNode ainenableF = ainF;
	    		
	    		for (int i = 0; i < 5; ++i) {
	    			ainenableF = ainenableF.getNext();
	    		}
	    		
	    		AbstractInsnNode ainenableG = ainG;
	    		
	    		for (int i = 0; i < 5; ++i) {
	    			ainenableG = ainenableG.getNext();
	    		}
	    		
	    		LabelNode ifconditionD = new LabelNode();
	    		InsnList ifpartD = new InsnList();
	    		ifpartD.add(new IntInsnNode(BIPUSH, 15));
	    		ifpartD.add(new MethodInsnNode(INVOKESTATIC, ClassNames.block, ClassNames.getBlockByID, "(I)" + ClassNames.getDesc(ClassNames.block), false));
	    		ifpartD.add(new VarInsnNode(ALOAD, 0));
	    		ifpartD.add(new JumpInsnNode(IF_ACMPNE, ifconditionD));
	    		methodNode.instructions.insertBefore(ainD, ifpartD);
	    		methodNode.instructions.insert(ainenableD, ifconditionD);
	    		
	    		LabelNode ifcondition = new LabelNode();
	    		InsnList ifpart = new InsnList();
	    		ifpart.add(new IntInsnNode(BIPUSH, 56));
	    		ifpart.add(new MethodInsnNode(INVOKESTATIC, ClassNames.block, ClassNames.getBlockByID, "(I)" + ClassNames.getDesc(ClassNames.block), false));
	    		ifpart.add(new VarInsnNode(ALOAD, 0));
	    		ifpart.add(new JumpInsnNode(IF_ACMPNE, ifcondition));
	    		methodNode.instructions.insertBefore(ain, ifpart);
	    		methodNode.instructions.insert(ainenable, ifcondition);
	    		
	    		LabelNode ifconditionE = new LabelNode();
	    		InsnList ifpartE = new InsnList();
	    		ifpartE.add(new IntInsnNode(SIPUSH, 129));
	    		ifpartE.add(new MethodInsnNode(INVOKESTATIC, ClassNames.block, ClassNames.getBlockByID, "(I)" + ClassNames.getDesc(ClassNames.block), false));
	    		ifpartE.add(new VarInsnNode(ALOAD, 0));
	    		ifpartE.add(new JumpInsnNode(IF_ACMPNE, ifconditionE));
	    		methodNode.instructions.insertBefore(ainE, ifpartE);
	    		methodNode.instructions.insert(ainenableE, ifconditionE);
	    		
	    		LabelNode ifconditionF = new LabelNode();
	    		InsnList ifpartF = new InsnList();
	    		ifpartF.add(new IntInsnNode(BIPUSH, 14));
	    		ifpartF.add(new MethodInsnNode(INVOKESTATIC, ClassNames.block, ClassNames.getBlockByID, "(I)" + ClassNames.getDesc(ClassNames.block), false));
	    		ifpartF.add(new VarInsnNode(ALOAD, 0));
	    		ifpartF.add(new JumpInsnNode(IF_ACMPNE, ifconditionF));
	    		methodNode.instructions.insertBefore(ainF, ifpartF);
	    		methodNode.instructions.insert(ainenableF, ifconditionF);
	    		
	    		LabelNode ifconditionG = new LabelNode();
	    		InsnList ifpartG = new InsnList();
	    		ifpartG.add(new IntInsnNode(BIPUSH, 21));
	    		ifpartG.add(new MethodInsnNode(INVOKESTATIC, ClassNames.block, ClassNames.getBlockByID, "(I)" + ClassNames.getDesc(ClassNames.block), false));
	    		ifpartG.add(new VarInsnNode(ALOAD, 0));
	    		ifpartG.add(new JumpInsnNode(IF_ACMPNE, ifconditionG));
	    		methodNode.instructions.insertBefore(ainG, ifpartG);
	    		methodNode.instructions.insert(ainenableG, ifconditionG);
	    		
	    		
	    		AbstractInsnNode ain1 = null;
	                
                for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
                    if (abs.getOpcode() == INVOKESTATIC) {
                        if (abs.getNext().getOpcode() == GETFIELD && abs.getNext().getNext().getOpcode() == ICONST_1) {
                            ain1 = abs;
                        }
                    }
                }
                
                AbstractInsnNode ainenable1 = ain1;
                
                for (int i = 0; i < 5; ++i) {
                    ainenable1 = ainenable1.getNext();
                }
                
                LabelNode ifcondition1 = new LabelNode();
                InsnList ifpart1 = new InsnList();
                ifpart1.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/XRay", "getStatus", "()Z",false));
                ifpart1.add(new JumpInsnNode(IFEQ, ifcondition1));
                
                methodNode.instructions.insertBefore(ain1, ifpart1);
                methodNode.instructions.insert(ainenable1, ifcondition1);
	    	}
	    }
	}
}
