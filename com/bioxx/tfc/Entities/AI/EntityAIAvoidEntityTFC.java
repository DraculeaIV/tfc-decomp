/*     */ package com.bioxx.tfc.Entities.AI;
/*     */ 
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.IEntitySelector;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.RandomPositionGenerator;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.pathfinding.PathEntity;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityAIAvoidEntityTFC
/*     */   extends EntityAIBase
/*     */ {
/*  21 */   public final IEntitySelector field_98218_a = new EntityAIAvoidEntitySelectorTFC(this);
/*     */   
/*     */   private EntityCreature theEntity;
/*     */   
/*     */   private double farSpeed;
/*     */   
/*     */   private double nearSpeed;
/*     */   
/*     */   private Entity closestLivingEntity;
/*     */   
/*     */   private float distanceFromEntity;
/*     */   
/*     */   private PathEntity entityPathEntity;
/*     */   
/*     */   private PathNavigate entityPathNavigate;
/*     */   
/*     */   private Class targetEntityClass;
/*     */ 
/*     */   
/*     */   public EntityAIAvoidEntityTFC(EntityCreature par1EntityCreature, Class par2Class, float par3, double par4, double par6) {
/*  41 */     this.theEntity = par1EntityCreature;
/*  42 */     this.targetEntityClass = par2Class;
/*  43 */     this.distanceFromEntity = par3;
/*  44 */     this.farSpeed = par4;
/*  45 */     this.nearSpeed = par6;
/*  46 */     this.entityPathNavigate = par1EntityCreature.func_70661_as();
/*  47 */     func_75248_a(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*  56 */     if (this.targetEntityClass == EntityPlayer.class) {
/*     */       
/*  58 */       if (this.theEntity instanceof IAnimal && ((IAnimal)this.theEntity).checkFamiliarity(IAnimal.InteractionEnum.TOLERATEPLAYER, null)) {
/*  59 */         return false;
/*     */       }
/*  61 */       if (this.theEntity instanceof EntityTameable && ((EntityTameable)this.theEntity).func_70909_n())
/*     */       {
/*  63 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  67 */     List<Entity> list = this.theEntity.field_70170_p.func_82733_a(this.targetEntityClass, this.theEntity.field_70121_D.func_72314_b(this.distanceFromEntity, 3.0D, this.distanceFromEntity), this.field_98218_a);
/*     */     
/*  69 */     if (list.isEmpty()) {
/*  70 */       return false;
/*     */     }
/*  72 */     this.closestLivingEntity = list.get(0);
/*     */     
/*  74 */     Vec3 vec3 = RandomPositionGenerator.func_75461_b(this.theEntity, 16, 7, Vec3.func_72443_a(this.closestLivingEntity.field_70165_t, this.closestLivingEntity.field_70163_u, this.closestLivingEntity.field_70161_v));
/*  75 */     if (vec3 == null)
/*  76 */       return false; 
/*  77 */     if (this.closestLivingEntity.func_70092_e(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c) < this.closestLivingEntity.func_70068_e((Entity)this.theEntity)) {
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     this.entityPathEntity = this.entityPathNavigate.func_75488_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
/*  82 */     return (this.entityPathEntity == null) ? false : this.entityPathEntity.func_75880_b(vec3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  92 */     return !this.entityPathNavigate.func_75500_f();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/* 101 */     this.entityPathNavigate.func_75484_a(this.entityPathEntity, this.farSpeed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/* 110 */     this.closestLivingEntity = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75246_d() {
/* 119 */     if (this.theEntity.func_70068_e(this.closestLivingEntity) < 49.0D) {
/* 120 */       this.theEntity.func_70661_as().func_75489_a(this.nearSpeed);
/*     */     } else {
/* 122 */       this.theEntity.func_70661_as().func_75489_a(this.farSpeed);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static EntityCreature getEntity(EntityAIAvoidEntityTFC par0EntityAIAvoidEntity) {
/* 127 */     return par0EntityAIAvoidEntity.theEntity;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\AI\EntityAIAvoidEntityTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */