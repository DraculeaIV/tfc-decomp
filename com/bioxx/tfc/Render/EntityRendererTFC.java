/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.EntityRenderer;
/*    */ import net.minecraft.client.resources.IResourceManager;
/*    */ import net.minecraft.client.shader.ShaderGroup;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityRendererTFC
/*    */   extends EntityRenderer
/*    */ {
/*    */   private boolean allowShaderSwitching = true;
/*    */   private ResourceLocation currentShader;
/*    */   
/*    */   public EntityRendererTFC(Minecraft minecraft, IResourceManager irm) {
/* 23 */     super(minecraft, irm);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147703_b() {
/* 29 */     if (this.allowShaderSwitching) {
/* 30 */       super.func_147705_c();
/*    */     }
/*    */   }
/*    */   
/*    */   public void setManualShader(ResourceLocation shaderLocation) {
/* 35 */     deactivateManualShader();
/*    */     try {
/* 37 */       Minecraft mc = Minecraft.func_71410_x();
/* 38 */       this.field_147707_d = new ShaderGroup(mc.func_110434_K(), mc.func_110442_L(), mc.func_147110_a(), shaderLocation);
/* 39 */       this.field_147707_d.func_148026_a(mc.field_71443_c, mc.field_71440_d);
/* 40 */       this.currentShader = shaderLocation;
/*    */     }
/* 42 */     catch (IOException ioexception) {
/*    */       
/* 44 */       LogManager.getLogger().warn("Failed to load shader: " + shaderLocation, ioexception);
/*    */     } 
/* 46 */     this.allowShaderSwitching = false;
/*    */   }
/*    */   
/*    */   public void deactivateManualShader() {
/* 50 */     this.allowShaderSwitching = true;
/* 51 */     super.func_147703_b();
/*    */   }
/*    */   
/*    */   public ResourceLocation getCurrentShaderLocation() {
/* 55 */     return this.currentShader;
/*    */   }
/*    */   
/*    */   public boolean getManualShaderBeingUsed() {
/* 59 */     return !this.allowShaderSwitching;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147705_c() {
/* 65 */     if (this.allowShaderSwitching)
/* 66 */       super.func_147705_c(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\EntityRendererTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */