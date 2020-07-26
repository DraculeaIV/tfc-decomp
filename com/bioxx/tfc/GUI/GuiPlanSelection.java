/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.ContainerPlanSelection;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEAnvil;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilRecipe;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilReq;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiPlanSelection
/*     */   extends GuiContainerTFC
/*     */ {
/*     */   private TEAnvil anvilTE;
/*     */   private List<Object[]> plans;
/*  31 */   public static ResourceLocation texture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_plan.png");
/*     */ 
/*     */   
/*     */   public GuiPlanSelection(EntityPlayer p, TEAnvil te, World w, int x, int y, int z) {
/*  35 */     super((Container)new ContainerPlanSelection(p, te, w, x, y, z), 176, 130);
/*  36 */     this.anvilTE = te;
/*     */ 
/*     */     
/*  39 */     this.drawInventory = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  48 */     super.func_73866_w_();
/*     */     
/*  50 */     this.field_146292_n.clear();
/*  51 */     this.plans = getRecipes();
/*  52 */     this.field_147003_i = (this.field_146294_l - this.field_146999_f) / 2;
/*  53 */     this.field_147009_r = (this.field_146295_m - this.field_147000_g) / 2;
/*  54 */     int xOffset = 5;
/*  55 */     int yOffset = 14;
/*  56 */     int index = this.plans.size() - 1;
/*  57 */     for (Object[] o : this.plans) {
/*     */       
/*  59 */       String p = (String)o[0];
/*  60 */       AnvilRecipe a = (AnvilRecipe)o[1];
/*  61 */       this.field_146292_n.add(0, new GuiPlanButton(this.plans.size() - 1 - index, this.field_147003_i + xOffset, this.field_147009_r + yOffset, 16, 16, a.getCraftingResult(), this, TFC_Core.translate("gui.plans." + p)));
/*  62 */       index--;
/*  63 */       if (xOffset + 36 < this.field_146999_f) {
/*  64 */         xOffset += 18;
/*     */         continue;
/*     */       } 
/*  67 */       xOffset = 5;
/*  68 */       yOffset += 18;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton guibutton) {
/*  76 */     Object[] p = (Object[])this.plans.toArray()[guibutton.field_146127_k];
/*  77 */     this.anvilTE.setPlan((String)p[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73732_a(FontRenderer fontrenderer, String s, int i, int j, int k) {
/*  83 */     fontrenderer.func_78276_b(s, i - fontrenderer.func_78256_a(s) / 2, j, k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float f, int i, int j) {
/*  89 */     drawGui(texture);
/*  90 */     if (this.anvilTE.func_70301_a(1) != null) {
/*  91 */       func_73732_a(this.field_146289_q, "Plans: " + this.anvilTE.func_70301_a(1).func_82833_r(), this.field_147003_i + this.field_146999_f / 2, this.field_147009_r + 5, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   private List<Object[]> getRecipes() {
/*  96 */     AnvilManager manager = AnvilManager.getInstance();
/*  97 */     Object[] plans = manager.getPlans().keySet().toArray();
/*  98 */     ArrayList<Object[]> planList = new ArrayList();
/*  99 */     for (Object p : plans) {
/*     */       
/* 101 */       AnvilRecipe ar = manager.findMatchingRecipe(new AnvilRecipe(this.anvilTE.anvilItemStacks[1], this.anvilTE.anvilItemStacks[5], (String)p, AnvilReq.getReqFromInt(this.anvilTE.anvilTier), null));
/*     */       
/* 103 */       ar = handleMatchingRecipe(ar);
/* 104 */       if (ar != null) {
/* 105 */         planList.add(new Object[] { p, ar });
/*     */       }
/*     */     } 
/* 108 */     return planList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AnvilRecipe handleMatchingRecipe(AnvilRecipe ar) {
/* 114 */     if (ar != null && 
/* 115 */       this.anvilTE.anvilItemStacks[1] != null && this.anvilTE.anvilItemStacks[1].func_77973_b() == TFCItems.bloom && ar.getCraftingResult().func_77973_b() == TFCItems.bloom)
/*     */     {
/* 117 */       if (this.anvilTE.anvilItemStacks[1].func_77960_j() <= 100)
/* 118 */         return null; 
/*     */     }
/* 120 */     return ar;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawTooltip(int mx, int my, String text) {
/* 126 */     List<String> list = new ArrayList<String>();
/* 127 */     list.add(text);
/* 128 */     drawHoveringTextZLevel(list, mx, my + 15, this.field_146289_q, 400.0F);
/* 129 */     RenderHelper.func_74518_a();
/* 130 */     GL11.glDisable(2896);
/* 131 */     GL11.glDisable(2929);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiPlanSelection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */