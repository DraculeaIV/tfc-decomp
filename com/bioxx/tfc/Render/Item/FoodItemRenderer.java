/*     */ package com.bioxx.tfc.Render.Item;
/*     */ 
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.Interfaces.IFood;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FoodItemRenderer
/*     */   implements IItemRenderer
/*     */ {
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/*  22 */     return (type == IItemRenderer.ItemRenderType.INVENTORY);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/*  27 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack is, Object... data) {
/*  33 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  34 */     GL11.glPushAttrib(8192);
/*  35 */     GL11.glEnable(2929);
/*  36 */     GL11.glEnable(3042);
/*  37 */     GL11.glBlendFunc(770, 771);
/*  38 */     if (is.func_77973_b() instanceof IFood && is.func_77942_o()) {
/*     */       
/*  40 */       renderIcon(0, 0, is.func_77973_b().func_77650_f(is), 16, 16);
/*  41 */       float decayPerc = Math.max(Food.getDecay(is) / Food.getWeight(is), 0.0F);
/*  42 */       float cookPerc = Math.max(Math.min(Food.getCooked(is) / 600.0F, 1.0F), 0.0F);
/*  43 */       if (is.func_77973_b() instanceof ItemFoodTFC) {
/*     */         
/*  45 */         int color = Food.getCookedColorMultiplier(is);
/*  46 */         GL11.glColor4f(((color & 0xFF0000) >> 16) / 255.0F, ((color & 0xFF00) >> 8) / 255.0F, (color & 0xFF) / 255.0F, cookPerc);
/*  47 */         if (((ItemFoodTFC)is.func_77973_b()).cookedIcon != null) {
/*  48 */           renderIcon(0, 0, ((ItemFoodTFC)is.func_77973_b()).cookedIcon, 16, 16);
/*     */         } else {
/*  50 */           renderIcon(0, 0, is.func_77973_b().func_77650_f(is), 16, 16);
/*     */         } 
/*  52 */       }  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  53 */       float decayTop = decayPerc * 13.0F;
/*     */       
/*  55 */       if (type == IItemRenderer.ItemRenderType.INVENTORY) {
/*     */         
/*  57 */         if (TFC_ItemHeat.hasTemp(is)) {
/*     */           
/*  59 */           float meltTemp = TFC_ItemHeat.isCookable(is);
/*  60 */           float temp = TFC_ItemHeat.getTemp(is);
/*  61 */           if (temp > 0.0F && temp < meltTemp) {
/*     */             
/*  63 */             renderQuad(1.0D, 1.0D, 13.0D, 1.0D, 0);
/*     */             
/*  65 */             float tempValue = 13.0F / meltTemp * temp;
/*  66 */             if (tempValue < 0.0F) tempValue = 0.0F; 
/*  67 */             if (tempValue > 13.0F) tempValue = 13.0F;
/*     */             
/*  69 */             if (temp < meltTemp * 0.1F) {
/*  70 */               renderQuad(1.0D, 1.0D, tempValue, 1.0D, 16777215);
/*  71 */             } else if (temp < meltTemp * 0.4F) {
/*  72 */               renderQuad(1.0D, 1.0D, tempValue, 1.0D, 16744448);
/*  73 */             } else if (temp < meltTemp * 0.8F) {
/*  74 */               renderQuad(1.0D, 1.0D, tempValue, 1.0D, 16736256);
/*     */             } else {
/*  76 */               renderQuad(1.0D, 1.0D, tempValue, 1.0D, 16711680);
/*     */             } 
/*     */           } 
/*     */         } 
/*  80 */         float weightPerc = Food.getWeight(is) / ((IFood)is.func_77973_b()).getFoodMaxWeight(is);
/*     */         
/*  82 */         if (weightPerc <= 1.0F)
/*     */         {
/*  84 */           if (((IFood)is.func_77973_b()).renderDecay())
/*     */           {
/*  86 */             if (decayPerc < 0.1D) {
/*     */               
/*  88 */               decayTop *= 10.0F;
/*  89 */               renderQuad(1.0D, 13.0D, (13.0F - decayTop), 1.0D, 65280);
/*     */             } else {
/*     */               
/*  92 */               renderQuad(1.0D, 13.0D, (13.0F - decayTop), 1.0D, 16711680);
/*     */             }  } 
/*  94 */           if (((IFood)is.func_77973_b()).renderWeight())
/*     */           {
/*  96 */             renderQuad(1.0D, 14.0D, 13.0D, 1.0D, 0);
/*  97 */             float weightTop = weightPerc * 13.0F;
/*     */             
/*  99 */             renderQuad(1.0D, 14.0D, weightTop, 1.0D, 16777215);
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       } 
/* 105 */     } else if (is.func_77973_b() instanceof IFood) {
/*     */       
/* 107 */       renderIcon(0, 0, is.func_77973_b().func_77650_f(is), 16, 16);
/*     */     } 
/*     */     
/* 110 */     GL11.glPopAttrib();
/* 111 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderIcon(int x, int y, IIcon icon, int sizeX, int sizeY) {
/* 116 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 117 */     tessellator.func_78382_b();
/* 118 */     tessellator.func_78374_a((x + 0), (y + sizeY), 0.0D, icon.func_94209_e(), icon.func_94210_h());
/* 119 */     tessellator.func_78374_a((x + sizeX), (y + sizeY), 0.0D, icon.func_94212_f(), icon.func_94210_h());
/* 120 */     tessellator.func_78374_a((x + sizeX), (y + 0), 0.0D, icon.func_94212_f(), icon.func_94206_g());
/* 121 */     tessellator.func_78374_a((x + 0), (y + 0), 0.0D, icon.func_94209_e(), icon.func_94206_g());
/* 122 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void renderQuad(double x, double y, double sizeX, double sizeY, int color) {
/* 127 */     GL11.glDisable(3553);
/* 128 */     Tessellator tess = Tessellator.field_78398_a;
/* 129 */     tess.func_78382_b();
/* 130 */     tess.func_78378_d(color);
/* 131 */     tess.func_78377_a(x + 0.0D, y + 0.0D, 0.0D);
/* 132 */     tess.func_78377_a(x + 0.0D, y + sizeY, 0.0D);
/* 133 */     tess.func_78377_a(x + sizeX, y + sizeY, 0.0D);
/* 134 */     tess.func_78377_a(x + sizeX, y + 0.0D, 0.0D);
/* 135 */     tess.func_78381_a();
/* 136 */     GL11.glEnable(3553);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Item\FoodItemRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */