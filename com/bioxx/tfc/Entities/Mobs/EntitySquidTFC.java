/*    */ package com.bioxx.tfc.Entities.Mobs;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.passive.EntitySquid;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntitySquidTFC
/*    */   extends EntitySquid
/*    */ {
/*    */   public EntitySquidTFC(World par1World) {
/* 18 */     super(par1World);
/* 19 */     func_70105_a(0.75F, 0.75F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70601_bi() {
/* 28 */     return (this.field_70163_u > 128.0D && this.field_70163_u <= 144.0D && this.field_70170_p.func_72855_b(this.field_70121_D));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70692_ba() {
/* 33 */     return !func_94056_bM();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 39 */     super.func_110147_ax();
/* 40 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer player) {
/* 45 */     ItemStack itemstack = player.func_70694_bm();
/* 46 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/* 47 */       String name = itemstack.field_77990_d.func_74779_i("ItemName");
/*    */       
/* 49 */       func_94058_c(name);
/* 50 */       itemstack.field_77994_a--;
/*    */       
/* 52 */       return true;
/*    */     } 
/* 54 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_70628_a(boolean par1, int par2) {
/* 64 */     int j = this.field_70146_Z.nextInt(3 + par2) + 1;
/* 65 */     for (int k = 0; k < j; k++) {
/* 66 */       func_70099_a(new ItemStack(TFCItems.dye, 1, 0), 0.0F);
/*    */     }
/* 68 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.calamariRaw, 5.0F + 10.0F * this.field_70146_Z.nextFloat());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntitySquidTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */