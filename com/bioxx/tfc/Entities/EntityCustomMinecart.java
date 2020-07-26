/*    */ package com.bioxx.tfc.Entities;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.item.EntityMinecartChest;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class EntityCustomMinecart
/*    */   extends EntityMinecartChest
/*    */ {
/*    */   public EntityCustomMinecart(World par1World) {
/* 15 */     super(par1World);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityCustomMinecart(World par1, double par2, double par4, double par6) {
/* 20 */     super(par1, par2, par4, par6);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94095_a(DamageSource par1DamageSource) {
/* 26 */     super.func_94095_a(par1DamageSource);
/* 27 */     func_145778_a(Item.func_150898_a(TFCBlocks.chest), 1, 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_70302_i_() {
/* 36 */     return 18;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_94087_l() {
/* 42 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Block func_145817_o() {
/* 48 */     return TFCBlocks.chest;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_94085_r() {
/* 54 */     return 8;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\EntityCustomMinecart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */