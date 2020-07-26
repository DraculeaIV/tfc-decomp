/*    */ package com.bioxx.tfc.Entities.Mobs;
/*    */ 
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityPigZombieTFC
/*    */   extends EntityZombieTFC
/*    */ {
/*    */   public EntityPigZombieTFC(World par1World) {
/* 21 */     super(par1World);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_70628_a(boolean par1, int par2) {
/* 40 */     int var3 = this.field_70146_Z.nextInt(2 + par2);
/*    */     int var4;
/* 42 */     for (var4 = 0; var4 < var3; var4++) {
/* 43 */       func_145779_a(Items.field_151078_bh, 1);
/*    */     }
/* 45 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/* 46 */     for (var4 = 0; var4 < var3; var4++) {
/* 47 */       func_145779_a(Items.field_151074_bl, 1);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_70600_l(int par1) {
/* 53 */     func_145779_a(Items.field_151043_k, 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Item func_146068_u() {
/* 62 */     return Items.field_151078_bh;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_82164_bB() {
/* 68 */     func_70062_b(0, new ItemStack(Items.field_151010_B));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 74 */     super.func_110147_ax();
/* 75 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(200.0D);
/* 76 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityPigZombieTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */