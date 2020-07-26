/*    */ package com.bioxx.tfc.Entities;
/*    */ 
/*    */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*    */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityJavelin
/*    */   extends EntityProjectileTFC
/*    */   implements ICausesDamage
/*    */ {
/*    */   public EntityJavelin(World par1World) {
/* 13 */     super(par1World);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityJavelin(World par1World, double i, double j, double k) {
/* 18 */     super(par1World, i, j, k);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityJavelin(World world, EntityLivingBase shooter, EntityLivingBase victim, float force, float forceVariation) {
/* 23 */     super(world, shooter, victim, force, forceVariation);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityJavelin(World par1World, EntityLivingBase shooter, float force) {
/* 28 */     super(par1World, shooter, force);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumDamageType getDamageType() {
/* 34 */     return EnumDamageType.PIERCING;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\EntityJavelin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */