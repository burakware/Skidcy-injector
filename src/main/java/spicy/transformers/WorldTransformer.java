package spicy.transformers;

import java.util.List;

import spicy.ClassNames;
import spicy.Injector;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class WorldTransformer extends Injector {
	
	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
	    for (MethodNode methodNode : (List<MethodNode>)classNode.methods) {
	    	if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.world)) && methodNode.name.equals(ClassNames.updateEntityWithOptionalForce)) && methodNode.desc.equals("(" + ClassNames.getDesc(ClassNames.entity) + "Z)V")) {
	    		AbstractInsnNode targetInsert = null;
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == RETURN) {
	    				targetInsert = abs;
	    				break;
	    			}
	    		}
	    		
	    		InsnList toInsert = new InsnList();
	    		
	    		toInsert.add(new VarInsnNode(ALOAD, 1));
	    		toInsert.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/utils/AttackUtils", "attack", "(" + ClassNames.getDesc(ClassNames.entity) + ")V", false));
	    		
	    		methodNode.instructions.insert(toInsert);
	    	}
	    }
	}
}
