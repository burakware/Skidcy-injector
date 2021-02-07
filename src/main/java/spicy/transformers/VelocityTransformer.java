package spicy.transformers;

import java.util.List;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import spicy.ClassNames;
import spicy.Injector;

public class VelocityTransformer extends Injector {

	public int control = 0;

	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>)classNode.methods) {
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.networkmanager)) && methodNode.name.equals(ClassNames.channelRead0)) && methodNode.desc.equals("(Lio/netty/channel/ChannelHandlerContext;" + ClassNames.getDesc(ClassNames.packet) + ")V")) {

				AbstractInsnNode yedekain = null;

				AbstractInsnNode ain1 = null;
				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == ALOAD && ((VarInsnNode)abs).var == 2) {
						ain1 = abs;
						yedekain = abs.getPrevious();
						break;
					}
				}

				methodNode.instructions.remove(ain1.getNext().getNext().getNext());
				methodNode.instructions.remove(ain1.getNext().getNext());
				methodNode.instructions.remove(ain1.getNext());
				methodNode.instructions.remove(ain1);
				InsnList ifpart = new InsnList();
				ifpart.add(new VarInsnNode(ALOAD, 2));
				ifpart.add(new VarInsnNode(ALOAD, 0));
				ifpart.add(new FieldInsnNode(GETFIELD, ClassNames.networkmanager, ClassNames.packetListener, "L" + ClassNames.inethandler + ";"));//yukardaki burası kısmı
				ifpart.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/utils/TransformerHelper", "packetListener", "(" + ClassNames.getDesc(ClassNames.packet) + "L" + ClassNames.inethandler + ";)V", false));

				methodNode.instructions.insert(yedekain, ifpart);
			}
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.networkmanager)) && methodNode.name.equals(ClassNames.dispatchPacket)) && methodNode.desc.equals("(" + ClassNames.getDesc(ClassNames.packet) + "[Lio/netty/util/concurrent/GenericFutureListener;)V")) {
				InsnList ifpart = new InsnList();
				ifpart.add(new TypeInsnNode(NEW, "xyz/spicy/event/events/PacketChatHelper"));
				ifpart.add(new InsnNode(DUP));
				ifpart.add(new VarInsnNode(ALOAD, 1));
				ifpart.add(new MethodInsnNode(INVOKESPECIAL, "xyz/spicy/event/events/PacketChatHelper", "<init>", "(" + ClassNames.getDesc(ClassNames.packet) + ")V", false));
				ifpart.add(new VarInsnNode(ASTORE,3));
				ifpart.add(new VarInsnNode(ALOAD,3));
				ifpart.add(new MethodInsnNode(INVOKEVIRTUAL,"xyz/spicy/event/events/PacketChatHelper" ,"call" ,"()Lxyz/spicy/event/Event;",false));
				ifpart.add(new InsnNode(POP));
				methodNode.instructions.insert(ifpart);


			}
		}
	}
}