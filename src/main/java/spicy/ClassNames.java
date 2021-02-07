package spicy;

public class ClassNames {

  public static String minecraft = "net/minecraft/client/O";
  public static String mcRenderGlobal = "j";
  public static String thePlayer = "Z";
  public static String rightclickdelay = "p";
  public static String theWorld = "aW";
  public static String mcGameSettings = "V";
  public static String mcPlayerController = "a";
  public static String getHandleClient = "a";
  public static String getMinecraft = "a";
  public static String runGame = "k";
  public static String runTick = "f";
  public static String entityplayersp = "net/minecraft/client/aC";
  public static String SPmovementInput = "cI";
  public static String onUpdateWalkingPlayer = "Y";
  public static String onLivingUpdate = "N";
  public static String entityplayer = "net/minecraft/cp";
  public static String inventory = "b9";
  public static String getHeldItem = "a";
  public static String entitylivingbase = "net/minecraft/bm";
  public static String isPotionActive = "b";
  public static String getActivePotionEffect = "a";
  public static String passSpecialRender = "b";
  public static String entity = "net/minecraft/bG";
  public static String prevposX = "H";
  public static String prevposY = "R";
  public static String prevposZ = "M";
  public static String posX = "S";
  public static String posY = "ah";
  public static String posZ = "J";
  public static String motionX = "I";
  public static String motionY = "t";
  public static String motionZ = "ag";
  public static String rotationYaw = "K";
  public static String rotationPitch = "Z";
  public static String prevRotationYaw = "aa";
  public static String prevRotationPitch = "e";
  public static String onground = "X";
  public static String ticksexisted = "c";
  public static String isUsingItem = "m";
  public static String moveEntity = "e";
  public static String eyeHeight = "k";
  public static String getDistanceToEntity = "a";
  public static String getName = "b";
  public static String isSneaking = "G";
  public static String entityrenderer = "net/minecraft/client/jY";
  public static String getMouseOver = "f";
  public static String iblockstate = "net/minecraft/jJ";
  public static String getBlock = "a";
  public static String keybinding = "net/minecraft/client/kX";
  public static String onTick = "b";
  public static String block = "net/minecraft/qq";
  public static String getBlockByID = "a";
  public static String shouldSideBeRendered = "b";
  public static String world = "net/minecraft/eC";
  public static String playerEntities = "s";
  public static String getBlockState = "a";
  public static String updateEntityWithOptionalForce = "a";
  public static String render = "net/minecraft/client/ha";
  public static String renderLivingLabel = "a";
  public static String playercontrollermp = "net/minecraft/client/bO";
  public static String curBlockDamageMP = "j";
  public static String blockHitDelay = "h";
  public static String func_180512_c = "b"; 
  public static String func_178890_a = "a"; 
  public static String item = "net/minecraft/tX";
  public static String itemstack = "net/minecraft/vN";
  public static String getItem = "a";
  public static String potion = "net/minecraft/wR"; 
  public static String id = "f";
  public static String potioneffect = "net/minecraft/wY";
  public static String guiingame = "net/minecraft/client/e5";
  public static String renderOverlay = "a";
  public static String gamesettings = "net/minecraft/client/k5";
  public static String ambientOcclusion = "a6";
  public static String gammaSettings = "k";
  public static String networkmanager = "net/minecraft/y9";
  public static String packetListener = "i";
  public static String channelRead0 = "a";
  public static String dispatchPacket = "a";
  public static String c02packetentityuse = "net/minecraft/hA";
  public static String c03packetplayer = "net/minecraft/c9";
  public static String c01packetchatmessage = "net/minecraft/uG";
  public static String s12packetentityvelocity = "net/minecraft/ou";
  public static String banpacket = "net/minecraft/ax";
  public static String rendererlivingentity = "net/minecraft/client/hL";
  public static String inventoryplayer = "net/minecraft/mV";
  public static String currentItem = "e";
  public static String getStackInSlot = "a";
  public static String getCurrentItem = "a";
  public static String enumfacing = "net/minecraft/dW";
  public static String itemblock = "net/minecraft/tK";
  public static String movementinput = "net/minecraft/iD";
  public static String moveStrafe = "a";
  public static String moveForward = "c";
  public static String jump = "b";
  public static String sneak = "d";
  public static String renderglobal = "net/minecraft/client/K";
  public static String loadRenderers = "g";
  public static String packet = "net/minecraft/uh";
  public static String nethandlerplayclient = "net/minecraft/client/lu";
  public static String addToSendQueue = "a";
  public static String worldclient = "net/minecraft/client/bx";
  public static String blocks = "net/minecraft/aU";
  public static String air = "bK";
  public static String flowing_water = "cb";
  public static String water = "b8";
  public static String flowing_lava = "ck";
  public static String lava = "cl";
  public static String fire = "b4";
  public static String web = "O";
  public static String tnt = "bt";
  public static String vec3 = "net/minecraft/oP";
  public static String vec3i = "net/minecraft/w8";
  public static String inethandler = "net/minecraft/dx";
  public static String iblockaccess = "net/minecraft/D";
  public static String add = "a";
  public static String getDesc(String name) {
    return "L" + name + ";";
  }

  public static String getNameIndex(String className) {
    int lastindex = 0;
    for (char c: className.toCharArray()) {
      if (c == '/') {++lastindex;
      }
    }
    return className.split("/")[lastindex];
  }

  public static String agentHelper(String className) {
    return className.replace("/", ".");
  }
}