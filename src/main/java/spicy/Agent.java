package spicy;

import spicy.transformers.*;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.Arrays;
// Note: I stole all this code from this series https://youtu.be/LlEBh81uyhg?t=365 cuz I am a script kid
public class Agent
{
    public static void agentmain(final String args, final Instrumentation instrumentation) {
        instrumentation.addTransformer(new ClientTransformer(), true);
        instrumentation.addTransformer(new PlayerControllerTransformer(), true);
        instrumentation.addTransformer(new XRayTransformer(), true);
        instrumentation.addTransformer(new XRayKeybindTransformer(), true);
        instrumentation.addTransformer(new GammaTransformer(), true);
        instrumentation.addTransformer(new VelocityTransformer(), true);
        instrumentation.addTransformer(new ScaffoldTransformer(), true);
        instrumentation.addTransformer(new EntityTransformer(), true);
        instrumentation.addTransformer(new ReachTransformer(), true);
        instrumentation.addTransformer(new WorldTransformer(), true);
        instrumentation.addTransformer(new GuiIngameTransformer(), true);
        instrumentation.addTransformer(new ConnectTransformer(), true);
        instrumentation.addTransformer(new AntiBanTransformer(), true);
        Arrays.stream(instrumentation.getAllLoadedClasses()).forEach(aClass -> {
          	if (aClass.getName().contains(ClassNames.banpacket.replace("/", ".")) && aClass.getName().contains("xyz.spicy.utils.TransformerHelper") && aClass.getName().contains("xyz.spicy.module.mods.Scaffold") && aClass.getName().contains(ClassNames.agentHelper(ClassNames.minecraft)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.render)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.rendererlivingentity)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.potion)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.entityplayer)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.keybinding)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.playercontrollermp)) && aClass.getName().contains(ClassNames.gamesettings) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.guiingame)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.networkmanager)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.entityrenderer)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.entityplayersp)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.world)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.block)) && aClass.getName().contains(ClassNames.agentHelper(ClassNames.entity))) {
                try {
                    instrumentation.retransformClasses(aClass); 
                }	
                catch (UnmodifiableClassException ex) {}
        	}
        });
    }
}
