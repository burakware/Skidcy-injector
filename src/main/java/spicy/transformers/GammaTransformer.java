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
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class GammaTransformer extends Injector {
	
	/*
	 * GameSettings class�
	 */
	
	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
	    for (MethodNode methodNode : (List<MethodNode>)classNode.methods) {
	    	if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.gamesettings)) && methodNode.name.equals("a")) && methodNode.desc.equals("(L" + ClassNames.keybinding + ";)Z")) {
	    		InsnList loadList = new InsnList();
	    		
				loadList.add(new MethodInsnNode(INVOKESTATIC, ClassNames.minecraft, ClassNames.getMinecraft, "()" + ClassNames.getDesc(ClassNames.minecraft), false));
				loadList.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.mcGameSettings, ClassNames.getDesc(ClassNames.gamesettings)));
	    		loadList.add(new LdcInsnNode(new Float("100.0")));
	    		loadList.add(new FieldInsnNode(PUTFIELD, ClassNames.gamesettings, ClassNames.gammaSettings, "F"));
	    		
	    		methodNode.instructions.insert(loadList);
	    		
	    		AbstractInsnNode ain2 = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == PUTFIELD) {
	    				if (abs.getPrevious().getPrevious().getOpcode() == GETFIELD && abs.getPrevious().getOpcode() != FCONST_1 && abs.getPrevious().getPrevious().getPrevious().getOpcode() == INVOKESTATIC) {
	    					ain2 = abs.getPrevious().getPrevious().getPrevious();
	    					
	    				}
	    			}
	    		}
	    		
	    		AbstractInsnNode ain3 = ain2;
	    		
	    		for (int i = 0; i < 3; ++i) {
	    			ain3 = ain3.getNext();
	    		}
	    		
	    		LabelNode ifpart = new LabelNode();
	    		InsnList ifinst = new InsnList(); // e�er a��ksa
	    		ifinst.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Brightness", "getStatus", "()Z",false));
	    		ifinst.add(new JumpInsnNode(IFEQ, ifpart));
	    		methodNode.instructions.insertBefore(ain2, ifinst);
	    		methodNode.instructions.insert(ain3,ifpart);
	    		
	    		InsnList loadListDisable = new InsnList();
	    		
	    		loadListDisable.add(new MethodInsnNode(INVOKESTATIC, ClassNames.minecraft, ClassNames.getMinecraft, "()" + ClassNames.getDesc(ClassNames.minecraft), false));
	    		loadListDisable.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.mcGameSettings, ClassNames.getDesc(ClassNames.gamesettings)));
	    		loadListDisable.add(new InsnNode(FCONST_1));// gamma settingsi 1 yap�yor
	    		loadListDisable.add(new FieldInsnNode(PUTFIELD, ClassNames.gamesettings, ClassNames.gammaSettings, "F"));
	    		
	    		methodNode.instructions.insert(loadListDisable);
	    		
	    		AbstractInsnNode ainDisable = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == PUTFIELD) {
	    				if (abs.getPrevious().getPrevious().getOpcode() == GETFIELD && abs.getPrevious().getOpcode() == FCONST_1 && abs.getPrevious().getPrevious().getPrevious().getOpcode() == INVOKESTATIC) {
	    					ainDisable = abs.getPrevious().getPrevious().getPrevious();
	    				}
	    			}
	    		}
	    		
	    		AbstractInsnNode ainDisableCopy = ainDisable;
	    		
	    		for (int i = 0; i < 3; ++i) {
	    			ainDisableCopy = ainDisableCopy.getNext();
	    		}
	    		
	    		LabelNode ifpartCopy = new LabelNode();
	    		InsnList ifinstCopy = new InsnList();
	    		ifinstCopy.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Brightness", "getStatus", "()Z",false));
	    		ifinstCopy.add(new JumpInsnNode(IFNE, ifpart));
	    		methodNode.instructions.insertBefore(ainDisable, ifinst);
	    		methodNode.instructions.insert(ainDisableCopy,ifpartCopy);
	    	}
	    }
	}
}
