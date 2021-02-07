package spicy;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;



public abstract class Injector implements ClassFileTransformer, Opcodes {


	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
		if (className.contains(ClassNames.minecraft)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.potion)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.entityplayer)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];
			}
		}
		if (className.contains(ClassNames.banpacket)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];
			}
		}
		if (className.contains(ClassNames.rendererlivingentity)) {
			try {
				
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.keybinding)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.entityplayersp)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.entity)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.block)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.render)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.playercontrollermp)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains("xyz/spicy/utils/TransformerHelper")) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains("xyz/spicy/module/mods/Scaffold") && !className.contains("BlockData")) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.world)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.gamesettings)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.networkmanager)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.guiingame)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.entityrenderer)) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		return new byte[0];
	}

	public abstract void inject(final ClassReader p0, final ClassNode p1);
}