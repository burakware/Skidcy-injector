package spicy.transformers;

import java.util.List;

import spicy.Injector;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

public class FastPlaceTransformer extends Injector {
	
	
	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
	    for (MethodNode methodNode : (List<MethodNode>)classNode.methods) {
	    	if ((classNode.name.contains("aH") && methodNode.name.equals("b")) && methodNode.desc.equals("()V")) {   	
	    		
	    		AbstractInsnNode fieldcontrol = null;
	    		
	    		
	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
	    			if (abs.getOpcode() == ICONST_1) {
	    				fieldcontrol = abs.getPrevious();
	    			}
	    		}
	    		
	    		InsnList toinsert = new InsnList();
	    		toinsert.add(new InsnNode(ICONST_0));
	    		
	    		methodNode.instructions.remove(fieldcontrol.getNext());
	    		
	    		methodNode.instructions.insert(fieldcontrol, toinsert);
	    	}
	    }
	}
}
