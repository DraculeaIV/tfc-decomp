/*    */ package com.bioxx.tfc.Entities.Mobs;
/*    */ 
/*    */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*    */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.monster.EntitySkeleton;
/*    */ import net.minecraft.entity.monster.EntitySpider;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class EntitySpiderTFC
/*    */   extends EntitySpider
/*    */   implements ICausesDamage
/*    */ {
/*    */   public EntitySpiderTFC(World par1World) {
/* 19 */     super(par1World);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 25 */     super.func_110147_ax();
/* 26 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(80.0D);
/* 27 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1800.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumDamageType getDamageType() {
/* 33 */     return EnumDamageType.PIERCING;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 39 */     super.func_70636_d();
/* 40 */     if (this.field_70153_n != null && this.field_70153_n instanceof EntitySkeleton && !this.field_70170_p.field_72995_K) {
/*    */       
/* 42 */       EntitySkeleton es = (EntitySkeleton)this.field_70153_n;
/* 43 */       es.func_110145_l(es.field_70154_o);
/* 44 */       es.func_70106_y();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70601_bi() {
/* 51 */     int x = MathHelper.func_76128_c(this.field_70165_t);
/* 52 */     int y = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 53 */     int z = MathHelper.func_76128_c(this.field_70161_v);
/* 54 */     Block b = this.field_70170_p.func_147439_a(x, y, z);
/*    */     
/* 56 */     if (b == TFCBlocks.leaves || b == TFCBlocks.leaves2 || b == TFCBlocks.thatch) {
/* 57 */       return false;
/*    */     }
/* 59 */     return super.func_70601_bi();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntitySpiderTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */