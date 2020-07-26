/*    */ package com.bioxx.tfc.api;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Armor
/*    */ {
/*  7 */   public static Armor[] armorArray = new Armor[256];
/*  8 */   public static Armor leather = new Armor(0, 200, 250, 300, "Leather");
/*  9 */   public static Armor leatherQuiver = new Armor(10, 0, 0, 0, "Leather Quiver");
/* 10 */   public static Armor copperPlate = new Armor(1, 400, 400, 250, "Copper");
/* 11 */   public static Armor bismuthBronzePlate = new Armor(2, 600, 400, 330, "Bismuth Bronze");
/* 12 */   public static Armor blackBronzePlate = new Armor(3, 400, 600, 330, "Black Bronze");
/* 13 */   public static Armor bronzePlate = new Armor(4, 500, 500, 330, "Bronze");
/* 14 */   public static Armor wroughtIronPlate = new Armor(5, 800, 800, 528, "Wrought Iron");
/* 15 */   public static Armor steelPlate = new Armor(6, 1000, 1200, 660, "Steel");
/* 16 */   public static Armor blackSteelPlate = new Armor(7, 2000, 1800, 1320, "Black Steel");
/* 17 */   public static Armor blueSteelPlate = new Armor(8, 2500, 2000, 2000, "Blue Steel");
/* 18 */   public static Armor redSteelPlate = new Armor(9, 2000, 2500, 2000, "Red Steel");
/*    */   
/*    */   private int armorRatingPiercing;
/*    */   private int armorRatingSlashing;
/*    */   private int armorRatingCrushing;
/*    */   public String metaltype;
/* 24 */   public int[] baseDurability = new int[] { 2500, 3750, 3000, 2500, 0 };
/*    */   
/*    */   public int armorId;
/*    */   
/*    */   public Armor(int id, int piercing, int slashing, int crushing, String material) {
/* 29 */     armorArray[id] = this;
/* 30 */     this.armorId = id;
/* 31 */     this.armorRatingPiercing = piercing;
/* 32 */     this.armorRatingSlashing = slashing;
/* 33 */     this.armorRatingCrushing = crushing;
/* 34 */     this.metaltype = material;
/*    */   }
/*    */ 
/*    */   
/*    */   public Armor(int id, int piercing, int slashing, int crushing, int[] dura, String material) {
/* 39 */     armorArray[id] = this;
/* 40 */     this.armorId = id;
/* 41 */     this.armorRatingPiercing = piercing;
/* 42 */     this.armorRatingSlashing = slashing;
/* 43 */     this.armorRatingCrushing = crushing;
/* 44 */     this.metaltype = material;
/* 45 */     this.baseDurability = (int[])dura.clone();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getDurability(int slot) {
/* 50 */     return this.baseDurability[slot];
/*    */   }
/*    */ 
/*    */   
/*    */   public int getPiercingAR() {
/* 55 */     return this.armorRatingPiercing;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSlashingAR() {
/* 60 */     return this.armorRatingSlashing;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCrushingAR() {
/* 65 */     return this.armorRatingCrushing;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Armor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */