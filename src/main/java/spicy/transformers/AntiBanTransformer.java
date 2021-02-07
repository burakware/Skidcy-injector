package spicy.transformers;

import org.objectweb.asm.ClassReader;
import spicy.ClassNames;
import spicy.Injector;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

public class AntiBanTransformer extends Injector {
    @Override
    public void inject(ClassReader classReader, ClassNode classNode) {
        for (MethodNode methodNode : (List<MethodNode>) classNode.methods) {
            if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.banpacket)) && methodNode.name.equals("b")) && methodNode.desc.equals("(Lnet/minecraft/d5;)V")) {
                AbstractInsnNode abstractInsnNode = null;
                int control = 0;
                for(AbstractInsnNode abs : methodNode.instructions.toArray()) {
                    if(abs.getOpcode() == ALOAD) {
                        ++control;
                        if(control == 3) {
                            abstractInsnNode = abs.getPrevious();
                            break;
                        }
                    }
                }
                methodNode.instructions.remove(abstractInsnNode.getNext().getNext().getNext());
                methodNode.instructions.remove(abstractInsnNode.getNext().getNext());
                methodNode.instructions.remove(abstractInsnNode.getNext());

            }
        }
    }
}
