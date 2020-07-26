/*     */ package com.bioxx.tfc.Handlers.Client;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.WeatherManager;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraftforge.client.event.EntityViewRenderEvent;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FogHandler
/*     */ {
/*  16 */   private double lerpTime = 14.0D;
/*     */   
/*     */   private double lerpTimer;
/*     */   private boolean rainLast;
/*     */   private boolean snowLast;
/*     */   private boolean shouldLerp;
/*     */   private float fogEnd;
/*     */   private float fogStart;
/*     */   private float fogDensity;
/*     */   private float fogEndBegin;
/*     */   private float fogStartBegin;
/*     */   private float fogDensityBegin;
/*     */   private float fogEndFinish;
/*     */   private float fogStartFinish;
/*     */   private float fogDensityFinish;
/*     */   private float localWorldFog;
/*     */   private float snowStrength;
/*  33 */   private int renderRange = 17;
/*     */ 
/*     */ 
/*     */   
/*     */   public FogHandler() {
/*  38 */     this.fogDensity = 0.1F;
/*  39 */     this.fogDensityBegin = 0.1F;
/*  40 */     this.fogDensityFinish = 0.1F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void renderFogHandler(EntityViewRenderEvent.RenderFogEvent event) {
/*  47 */     if (event.fogMode >= 0) {
/*     */ 
/*     */       
/*  50 */       if (this.renderRange != (Minecraft.func_71410_x()).field_71474_y.field_151451_c || this.fogEnd < 16.0F) {
/*     */         
/*  52 */         this.renderRange = (Minecraft.func_71410_x()).field_71474_y.field_151451_c;
/*     */ 
/*     */         
/*  55 */         this.fogStart = event.farPlaneDistance * 0.75F;
/*  56 */         this.fogEnd = event.farPlaneDistance;
/*     */       } 
/*     */ 
/*     */       
/*  60 */       if (this.shouldLerp) {
/*     */         
/*  62 */         this.lerpTimer += event.renderPartialTicks;
/*     */         
/*  64 */         if (this.lerpTimer >= this.lerpTime) {
/*  65 */           this.shouldLerp = false;
/*     */         }
/*     */ 
/*     */         
/*  69 */         this.fogStart = lerp(this.fogStartBegin, this.fogStartFinish, this.lerpTime, this.lerpTimer);
/*  70 */         this.fogEnd = lerp(this.fogEndBegin, this.fogEndFinish, this.lerpTime, this.lerpTimer);
/*  71 */         this.fogDensity = lerp(this.fogDensityBegin, this.fogDensityFinish, this.lerpTime, this.lerpTimer);
/*     */       } 
/*     */       
/*  74 */       calcFog(event);
/*     */       
/*  76 */       if ((int)event.entity.field_70163_u > 128) {
/*     */         
/*  78 */         GL11.glFogf(2914, Math.min(this.fogDensity, 0.3F));
/*  79 */         GL11.glFogf(2915, Math.max(this.fogStart, 8.0F));
/*  80 */         GL11.glFogf(2916, Math.max(this.fogEnd, 16.0F));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void calcFog(EntityViewRenderEvent.RenderFogEvent event) {
/*  87 */     if (this.renderRange < 6)
/*     */       return; 
/*  89 */     boolean raining = event.entity.field_70170_p.func_72896_J();
/*  90 */     float temp = TFC_Climate.getHeightAdjustedTemp(event.entity.field_70170_p, (int)event.entity.field_70165_t, (int)event.entity.field_70163_u, (int)event.entity.field_70161_v);
/*  91 */     float localFog = WeatherManager.getInstance().getLocalFog(event.entity.field_70170_p, (int)event.entity.field_70165_t, (int)event.entity.field_70163_u, (int)event.entity.field_70161_v);
/*  92 */     if (localFog != this.localWorldFog) {
/*  93 */       localFog = WeatherManager.getInstance().getLocalFog(event.entity.field_70170_p, (int)event.entity.field_70165_t, (int)event.entity.field_70163_u, (int)event.entity.field_70161_v);
/*     */     }
/*  95 */     if (raining && temp > 0.0F) {
/*     */       
/*  97 */       if (!this.rainLast || this.snowLast)
/*     */       {
/*  99 */         startLerp(600.0D);
/* 100 */         this.rainLast = true;
/* 101 */         this.snowLast = false;
/* 102 */         this.fogStartFinish = event.farPlaneDistance * 0.5F;
/* 103 */         this.fogEndFinish = event.farPlaneDistance * 0.75F;
/* 104 */         this.fogDensityFinish = 0.2F;
/*     */       }
/*     */     
/* 107 */     } else if (raining && temp <= 0.0F) {
/*     */       
/* 109 */       if (!this.snowLast)
/*     */       {
/* 111 */         startLerp(600.0D);
/* 112 */         this.rainLast = true;
/* 113 */         this.snowLast = true;
/* 114 */         this.snowStrength = WeatherManager.getInstance().getSnowStrength();
/* 115 */         this.fogStartFinish = event.farPlaneDistance * 0.1F;
/* 116 */         this.fogEndFinish = event.farPlaneDistance * (0.2F + 0.1F * this.snowStrength);
/* 117 */         this.fogDensityFinish = 0.3F;
/*     */       }
/* 119 */       else if (this.snowLast && WeatherManager.getInstance().getSnowStrength() != this.snowStrength)
/*     */       {
/* 121 */         startLerp(300.0D);
/* 122 */         this.snowStrength = WeatherManager.getInstance().getSnowStrength();
/* 123 */         this.fogStartFinish = event.farPlaneDistance * 0.1F;
/* 124 */         this.fogEndFinish = event.farPlaneDistance * (0.2F + 0.1F * this.snowStrength);
/* 125 */         this.fogDensityFinish = 0.3F;
/*     */       }
/*     */     
/* 128 */     } else if (localFog > 0.0F && localFog != this.localWorldFog) {
/*     */       
/* 130 */       startLerp(600.0D);
/* 131 */       this.localWorldFog = localFog;
/* 132 */       this.fogStartFinish = event.farPlaneDistance * 0.1F;
/* 133 */       this.fogEndFinish = event.farPlaneDistance * (0.6F - 0.3F * localFog);
/* 134 */       this.fogDensityFinish = 0.2F - 0.08F * localFog;
/*     */     }
/* 136 */     else if (!raining) {
/*     */       
/* 138 */       if (this.rainLast || (this.localWorldFog != 0.0F && localFog == 0.0F)) {
/*     */         
/* 140 */         startLerp(600.0D);
/* 141 */         this.localWorldFog = 0.0F;
/* 142 */         this.rainLast = false;
/* 143 */         this.snowLast = false;
/* 144 */         this.fogStartFinish = event.farPlaneDistance * 0.75F;
/* 145 */         this.fogEndFinish = event.farPlaneDistance;
/* 146 */         this.fogDensityFinish = 0.1F;
/*     */       }
/* 148 */       else if (!this.shouldLerp && this.localWorldFog == 0.0F) {
/*     */         
/* 150 */         this.fogStart = event.farPlaneDistance * 0.75F;
/* 151 */         this.fogEnd = event.farPlaneDistance;
/* 152 */         this.fogDensity = 0.1F;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float lerp(float start, float target, double duration, double timeSinceStart) {
/* 160 */     float value = start;
/* 161 */     if (timeSinceStart > 0.0D && timeSinceStart < duration) {
/*     */       
/* 163 */       float range = target - start;
/* 164 */       float percent = (float)(timeSinceStart / duration);
/* 165 */       value = start + range * percent;
/*     */     }
/* 167 */     else if (timeSinceStart >= duration) {
/*     */       
/* 169 */       value = target;
/*     */     } 
/* 171 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   private void startLerp(double ticks) {
/* 176 */     if (!this.shouldLerp) {
/*     */       
/* 178 */       this.shouldLerp = true;
/* 179 */       this.lerpTimer = 0.0D;
/* 180 */       this.lerpTime = ticks;
/* 181 */       this.fogStartBegin = this.fogStart;
/* 182 */       this.fogEndBegin = this.fogEnd;
/* 183 */       this.fogDensityBegin = this.fogDensity;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\FogHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */