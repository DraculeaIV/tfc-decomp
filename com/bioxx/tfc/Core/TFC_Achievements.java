/*    */ package com.bioxx.tfc.Core;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.stats.Achievement;
/*    */ import net.minecraftforge.common.AchievementPage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TFC_Achievements
/*    */ {
/*    */   public static Achievement achLooseRock;
/*    */   public static Achievement achSmallOre;
/*    */   public static Achievement achWildVegetable;
/*    */   public static Achievement achRutabaga;
/*    */   public static Achievement achDiamond;
/*    */   public static Achievement achAnvil;
/*    */   public static Achievement achQuern;
/*    */   public static Achievement achPickaxe;
/*    */   public static Achievement achStoneAge;
/*    */   public static Achievement achCopperAge;
/*    */   public static Achievement achBronzeAge;
/*    */   public static Achievement achIronAge;
/*    */   public static Achievement achLimonite;
/*    */   public static Achievement achSaw;
/*    */   public static Achievement achPokeCreeper;
/*    */   public static Achievement achTwoKnives;
/*    */   public static Achievement achBlastFurnace;
/*    */   public static Achievement achFireClay;
/*    */   public static Achievement achCrucible;
/*    */   public static Achievement achUnknown;
/*    */   public static Achievement achBlackSteel;
/*    */   public static Achievement achBlueSteel;
/*    */   public static Achievement achRedSteel;
/*    */   public static Achievement achBlueBucket;
/*    */   public static Achievement achRedBucket;
/*    */   private static List<Achievement> achlist;
/*    */   public static AchievementPage pageBiome;
/*    */   public static Achievement[] achievementsTFC;
/*    */   
/*    */   public TFC_Achievements() {
/* 49 */     init();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void init() {
/* 54 */     achlist = new ArrayList<Achievement>();
/*    */     
/* 56 */     achLooseRock = createAchievement("achievement.achLooseRock", "achLooseRock", 0, 0, new ItemStack(TFCItems.looseRock), null);
/* 57 */     achSmallOre = createAchievement("achievement.achSmallOre", "achSmallOre", 2, 0, new ItemStack(TFCItems.smallOreChunk), achLooseRock);
/* 58 */     achWildVegetable = createAchievement("achievement.achWildVegetable", "achWildVegetable", -3, -1, new ItemStack(TFCItems.onion), null);
/* 59 */     achRutabaga = createAchievement("achievement.achRutabaga", "achRutabaga", -3, 1, new ItemStack(TFCItems.onion, 1, 1), achWildVegetable);
/* 60 */     achStoneAge = createAchievement("achievement.achStoneAge", "achStoneAge", -1, -1, new ItemStack(TFCItems.igInStoneAxeHead), achLooseRock);
/* 61 */     achTwoKnives = createAchievement("achievement.achTwoKnives", "achTwoKnives", -1, -3, new ItemStack(TFCItems.stoneKnife), achStoneAge);
/* 62 */     achCopperAge = createAchievement("achievement.achCopperAge", "achCopperAge", 3, -1, new ItemStack(TFCItems.copperAxeHead), achSmallOre);
/* 63 */     achSaw = createAchievement("achievement.achSaw", "achSaw", 5, -1, new ItemStack(TFCItems.copperSaw), achCopperAge);
/* 64 */     achAnvil = createAchievement("achievement.achAnvil", "achAnvil", 1, 2, new ItemStack(TFCItems.stoneHammer, 1, 2), achStoneAge);
/* 65 */     achPickaxe = createAchievement("achievement.achPickaxe", "achPickaxe", 3, -3, new ItemStack(TFCItems.copperPick), achCopperAge);
/* 66 */     achQuern = createAchievement("achievement.achQuern", "achQuern", 3, -5, new ItemStack(TFCBlocks.quern), achPickaxe);
/* 67 */     achDiamond = createAchievement("achievement.achDiamond", "achDiamond", 1, -3, new ItemStack(TFCItems.gemDiamond, 1, 4), achPickaxe);
/* 68 */     achLimonite = createAchievement("achievement.achLimonite", "achLimonite", 5, -3, new ItemStack(TFCItems.oreChunk, 1, 11), achPickaxe);
/* 69 */     achBronzeAge = createAchievement("achievement.achBronzeAge", "achBronzeAge", 4, 1, new ItemStack(TFCBlocks.anvil, 1, 2), achCopperAge);
/* 70 */     achIronAge = createAchievement("achievement.achIronAge", "achIronAge", 5, 3, new ItemStack(TFCItems.rawBloom), achBronzeAge);
/* 71 */     achPokeCreeper = createAchievement("achievement.achPokeCreeper", "achPokeCreeper", -3, -3, new ItemStack(Items.field_151144_bL, 1, 4), null);
/* 72 */     achBlastFurnace = createAchievement("achievement.achBlastFurnace", "achBlastFurnace", 6, 1, new ItemStack(TFCBlocks.blastFurnace), achIronAge);
/* 73 */     achFireClay = createAchievement("achievement.achFireClay", "achFireClay", 5, -5, new ItemStack(TFCItems.clayBall, 1, 1), achQuern);
/* 74 */     achCrucible = createAchievement("achievement.achCrucible", "achCrucible", 7, -5, new ItemStack(TFCBlocks.crucible), achFireClay);
/* 75 */     achUnknown = createAchievement("achievement.achUnknown", "achUnknown", 7, -3, new ItemStack(TFCItems.unknownIngot), achCrucible);
/* 76 */     achBlackSteel = createAchievement("achievement.achBlackSteel", "achBlackSteel", 7, 0, new ItemStack(TFCItems.blackSteelIngot), achBlastFurnace);
/* 77 */     achBlueSteel = createAchievement("achievement.achBlueSteel", "achBlueSteel", 8, 1, new ItemStack(TFCItems.blueSteelIngot), achBlackSteel);
/* 78 */     achRedSteel = createAchievement("achievement.achRedSteel", "achRedSteel", 8, -1, new ItemStack(TFCItems.redSteelIngot), achBlackSteel);
/* 79 */     achBlueBucket = createAchievement("achievement.achBlueBucket", "achBlueBucket", 10, 1, new ItemStack(TFCItems.blueSteelBucketEmpty), achBlueSteel);
/* 80 */     achRedBucket = createAchievement("achievement.achRedBucket", "achRedBucket", 10, -1, new ItemStack(TFCItems.redSteelBucketEmpty), achRedSteel);
/*    */     
/* 82 */     achievementsTFC = new Achievement[achlist.size()];
/* 83 */     achievementsTFC = achlist.<Achievement>toArray(achievementsTFC);
/* 84 */     pageBiome = new AchievementPage("TerraFirmaCraft", achievementsTFC);
/* 85 */     AchievementPage.registerAchievementPage(pageBiome);
/*    */   }
/*    */ 
/*    */   
/*    */   private static Achievement createAchievement(String id, String name, int posX, int posY, ItemStack is, Achievement preReq) {
/* 90 */     Achievement a = (new Achievement(id, name, posX, posY, is, preReq)).func_75971_g();
/* 91 */     achlist.add(a);
/* 92 */     return a;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\TFC_Achievements.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */