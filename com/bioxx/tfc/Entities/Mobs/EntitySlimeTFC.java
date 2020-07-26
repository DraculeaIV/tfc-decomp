/*    */ package com.bioxx.tfc.Entities.Mobs;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.monster.EntitySlime;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntitySlimeTFC
/*    */   extends EntitySlime
/*    */ {
/*    */   public EntitySlimeTFC(World par1World) {
/* 15 */     super(par1World);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_70799_a(int par1) {
/* 21 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((par1 * 350));
/* 22 */     func_70606_j(func_110138_aP());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected EntitySlimeTFC createInstance() {
/* 28 */     return new EntitySlimeTFC(this.field_70170_p);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70106_y() {
/* 37 */     int var1 = func_70809_q();
/* 38 */     if (!this.field_70170_p.field_72995_K && var1 > 1 && func_110143_aJ() <= 0.0F) {
/*    */       
/* 40 */       int var2 = 2 + this.field_70146_Z.nextInt(3);
/* 41 */       for (int var3 = 0; var3 < var2; var3++) {
/*    */         
/* 43 */         float var4 = ((var3 % 2) - 0.5F) * var1 / 4.0F;
/* 44 */         float var5 = ((var3 / 2) - 0.5F) * var1 / 4.0F;
/* 45 */         EntitySlimeTFC var6 = createInstance();
/* 46 */         var6.func_70799_a(var1 / 2);
/* 47 */         var6.func_70012_b(this.field_70165_t + var4, this.field_70163_u + 0.5D, this.field_70161_v + var5, this.field_70146_Z.nextFloat() * 360.0F, 0.0F);
/* 48 */         this.field_70170_p.func_72838_d((Entity)var6);
/*    */       } 
/*    */     } 
/* 51 */     super.func_70106_y();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70100_b_(EntityPlayer par1EntityPlayer) {
/* 60 */     if (func_70800_m()) {
/*    */       
/* 62 */       int var2 = func_70809_q();
/* 63 */       if (func_70685_l((Entity)par1EntityPlayer) && func_70068_e((Entity)par1EntityPlayer) < 0.6D * var2 * 0.6D * var2 && par1EntityPlayer.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), func_70805_n())) {
/* 64 */         this.field_70170_p.func_72956_a((Entity)this, "mob.slime.attack", 1.0F, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean func_70800_m() {
/* 74 */     return (func_70809_q() > 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected int func_70805_n() {
/* 83 */     return func_70809_q() * 100;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntitySlimeTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */