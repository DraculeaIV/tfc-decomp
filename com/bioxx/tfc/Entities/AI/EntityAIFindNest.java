/*     */ package com.bioxx.tfc.Entities.AI;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityChickenTFC;
/*     */ import com.bioxx.tfc.TileEntities.TENestBox;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityAIFindNest
/*     */   extends EntityAIBase
/*     */ {
/*     */   private EntityCreature theCreature;
/*     */   private int currentTick;
/*     */   private World theWorld;
/*     */   private int movement;
/*     */   private final double field_75404_b;
/*     */   private int maxSittingTicks;
/*     */   private Map<String, Long> failureDepressionMap;
/*     */   private double compoundDistance;
/*     */   private int lastCheckedTick;
/*     */   private boolean end;
/*  41 */   private int sitableBlockX = -1;
/*     */ 
/*     */   
/*  44 */   private int sitableBlockY = -1;
/*     */ 
/*     */   
/*  47 */   private int sitableBlockZ = -1;
/*     */ 
/*     */   
/*     */   public EntityAIFindNest(EntityAnimal eAnimal, double par2) {
/*  51 */     this.theCreature = (EntityCreature)eAnimal;
/*     */     
/*  53 */     this.field_75404_b = par2;
/*  54 */     this.theWorld = eAnimal.field_70170_p;
/*  55 */     this.failureDepressionMap = new HashMap<String, Long>();
/*  56 */     func_75248_a(5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*  65 */     if (this.theCreature instanceof EntityChickenTFC && !(this.theCreature instanceof com.bioxx.tfc.Entities.Mobs.EntityPheasantTFC))
/*     */     {
/*  67 */       return (((EntityChickenTFC)this.theCreature).isAdult() && ((EntityChickenTFC)this.theCreature).getFamiliarity() >= 15 && this.theWorld
/*  68 */         .func_147439_a((int)this.theCreature.field_70165_t, (int)this.theCreature.field_70163_u, (int)this.theCreature.field_70161_v) != TFCBlocks.nestBox && this.theWorld
/*  69 */         .func_147439_a((int)this.theCreature.field_70165_t, (int)this.theCreature.field_70163_u - 1, (int)this.theCreature.field_70161_v) != TFCBlocks.nestBox && 
/*  70 */         getNearbySitableBlockDistance() && ((EntityChickenTFC)this.theCreature)
/*  71 */         .getGender() == IAnimal.GenderEnum.FEMALE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  90 */     if (this.theCreature.func_70092_e(this.sitableBlockX + 0.5D, this.sitableBlockY, this.sitableBlockZ + 0.5D) < 0.2D) {
/*  91 */       this.theCreature.func_70661_as().func_75499_g();
/*     */     }
/*  93 */     if (this.end) {
/*     */       
/*  95 */       this.end = false;
/*  96 */       return this.end;
/*     */     } 
/*  98 */     return (this.currentTick <= this.maxSittingTicks && this.movement <= 60 && isSittableBlock(this.theCreature.field_70170_p, this.sitableBlockX, this.sitableBlockY, this.sitableBlockZ));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean getNearbySitableBlockDistance() {
/* 103 */     int i = (int)this.theCreature.field_70163_u;
/* 104 */     double d0 = 2.147483647E9D;
/*     */     
/* 106 */     for (int j = (int)this.theCreature.field_70165_t - 16; j < this.theCreature.field_70165_t + 16.0D; j++) {
/*     */       
/* 108 */       for (int k = (int)this.theCreature.field_70161_v - 16; k < this.theCreature.field_70161_v + 16.0D; k++) {
/*     */         
/* 110 */         for (int l = i; l < i + 4; l++) {
/*     */           
/* 112 */           if (isSittableBlock(this.theCreature.field_70170_p, j, l, k) && this.theCreature.field_70170_p.func_147437_c(j, l + 1, k)) {
/*     */             
/* 114 */             double d1 = this.theCreature.func_70092_e(j, l, k);
/*     */             
/* 116 */             if (d1 < d0) {
/*     */               
/* 118 */               this.sitableBlockX = j;
/* 119 */               this.sitableBlockY = l;
/* 120 */               this.sitableBlockZ = k;
/* 121 */               d0 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 127 */     return (d0 < 2.147483647E9D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/* 135 */     this.theCreature.func_70661_as().func_75492_a(this.sitableBlockX + 0.5D, (this.sitableBlockY + 1), this.sitableBlockZ + 0.5D, this.field_75404_b);
/* 136 */     this.currentTick = 0;
/* 137 */     this.movement = 0;
/* 138 */     this.compoundDistance = 0.0D;
/* 139 */     this.lastCheckedTick = 0;
/* 140 */     this.end = false;
/* 141 */     this.maxSittingTicks = this.theCreature.func_70681_au().nextInt(this.theCreature.func_70681_au().nextInt(1200) + 1200) + 1200;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75246_d() {
/* 147 */     this.currentTick++;
/*     */     
/* 149 */     if (this.theCreature.func_70092_e(this.sitableBlockX, (this.sitableBlockY + 1), this.sitableBlockZ) > 1.0D) {
/*     */       
/* 151 */       this.theCreature.func_70661_as().func_75492_a(this.sitableBlockX + 0.5D, (this.sitableBlockY + 1), this.sitableBlockZ + 0.5D, this.field_75404_b);
/* 152 */       this.movement++;
/* 153 */       this.compoundDistance += this.theCreature.func_70011_f(this.theCreature.field_70142_S, this.theCreature.field_70137_T, this.theCreature.field_70136_U);
/* 154 */       if (this.currentTick - 40 > this.lastCheckedTick) {
/*     */         
/* 156 */         ArrayList<EntityChickenTFC> crowd = (ArrayList<EntityChickenTFC>)this.theCreature.field_70170_p.func_72872_a(EntityChickenTFC.class, this.theCreature.field_70121_D.func_72314_b(24.0D, 2.0D, 24.0D));
/* 157 */         ArrayList<EntityChickenTFC> invalid = new ArrayList<EntityChickenTFC>();
/* 158 */         for (EntityChickenTFC chicken : crowd) {
/* 159 */           if (chicken.getGender().equals(IAnimal.GenderEnum.MALE) || chicken.func_70631_g_()) {
/* 160 */             invalid.add(chicken);
/*     */           }
/*     */         } 
/* 163 */         crowd.removeAll(invalid);
/* 164 */         crowd.remove(this.theCreature);
/* 165 */         if (this.compoundDistance < 0.5D || crowd.size() >= 10)
/*     */         {
/* 167 */           this.failureDepressionMap.put(this.sitableBlockX + "," + this.sitableBlockY + "," + this.sitableBlockZ, Long.valueOf(TFC_Time.getTotalTicks() + 24000L));
/* 168 */           this.end = true;
/*     */         }
/*     */         else
/*     */         {
/* 172 */           this.lastCheckedTick = this.currentTick;
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 178 */       this.movement--;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSittableBlock(World world, int x, int y, int z) {
/* 187 */     if (this.failureDepressionMap.containsKey(x + "," + y + "," + z)) {
/*     */       
/* 189 */       long time = ((Long)this.failureDepressionMap.get(x + "," + y + "," + z)).longValue();
/* 190 */       if (time > TFC_Time.getTotalTicks()) {
/* 191 */         return false;
/*     */       }
/* 193 */       this.failureDepressionMap.remove(new int[] { x, y, z });
/*     */     } 
/*     */     
/* 196 */     Block block = world.func_147439_a(x, y, z);
/*     */     
/* 198 */     if (block == TFCBlocks.nestBox) {
/*     */       
/* 200 */       TENestBox tileentitynest = (TENestBox)world.func_147438_o(x, y, z);
/*     */       
/* 202 */       if (!tileentitynest.hasBird() || tileentitynest.getBird() == this.theCreature) {
/* 203 */         return true;
/*     */       }
/*     */     } 
/* 206 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\AI\EntityAIFindNest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */