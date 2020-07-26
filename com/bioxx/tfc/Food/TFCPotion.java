/*    */ package com.bioxx.tfc.Food;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.potion.Potion;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TFCPotion
/*    */   extends Potion
/*    */ {
/*    */   public static Potion bleed;
/*    */   public static Potion nausea;
/* 14 */   private String name = "";
/*    */ 
/*    */   
/* 17 */   private int statusIconIndex = -1;
/*    */ 
/*    */   
/*    */   public TFCPotion(int par1, boolean par2, int par3) {
/* 21 */     super(par1, par2, par3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public TFCPotion setIconIndex(int par1, int par2) {
/* 27 */     this.statusIconIndex = par1 + par2 * 8;
/* 28 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public TFCPotion setPotionName(String par1Str) {
/* 34 */     this.name = par1Str;
/* 35 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_76400_d() {
/* 46 */     return (this.statusIconIndex >= 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_76393_a() {
/* 52 */     return this.name;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_76392_e() {
/* 59 */     return this.statusIconIndex;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setup() {
/* 64 */     bleed = (new TFCPotion(20, true, 16711680)).setPotionName("effect.bleed").setIconIndex(4, 0).func_76404_a(0.25D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Food\TFCPotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */