/*    */ package com.bioxx.tfc.Entities.Mobs;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Achievements;
/*    */ import com.bioxx.tfc.api.Interfaces.IInnateArmor;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.monster.EntityCreeper;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.stats.StatBase;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityCreeperTFC
/*    */   extends EntityCreeper
/*    */   implements IInnateArmor {
/*    */   public EntityCreeperTFC(World par1World) {
/* 21 */     super(par1World);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 27 */     super.func_110147_ax();
/* 28 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 34 */     Entity entity = par1DamageSource.func_76346_g();
/* 35 */     if (entity != null && entity instanceof EntityPlayer && ((EntityPlayer)entity)
/* 36 */       .func_70694_bm() != null && ((EntityPlayer)entity).func_70694_bm().func_77973_b().equals(TFCItems.stick)) {
/* 37 */       ((EntityPlayer)entity).func_71029_a((StatBase)TFC_Achievements.achPokeCreeper);
/*    */     }
/* 39 */     return super.func_70097_a(par1DamageSource, par2);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCrushArmor() {
/* 44 */     return 1000;
/*    */   }
/*    */   
/*    */   public int getSlashArmor() {
/* 48 */     return 0;
/*    */   }
/*    */   
/*    */   public int getPierceArmor() {
/* 52 */     return -335;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70601_bi() {
/* 58 */     int x = MathHelper.func_76128_c(this.field_70165_t);
/* 59 */     int y = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 60 */     int z = MathHelper.func_76128_c(this.field_70161_v);
/* 61 */     Block b = this.field_70170_p.func_147439_a(x, y, z);
/*    */     
/* 63 */     if (b == TFCBlocks.leaves || b == TFCBlocks.leaves2 || b == TFCBlocks.thatch) {
/* 64 */       return false;
/*    */     }
/* 66 */     return super.func_70601_bi();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityCreeperTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */