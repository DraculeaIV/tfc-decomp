/*     */ package com.bioxx.tfc.Handlers.Client;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.FoodRegistry;
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.TickEvent;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.gui.inventory.GuiContainer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.IIcon;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FMLClientEventHandler
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   @SubscribeEvent
/*     */   public void renderTick(TickEvent.RenderTickEvent event) {
/*  34 */     Minecraft mc = FMLClientHandler.instance().getClient();
/*     */     
/*  36 */     if (event.phase != TickEvent.Phase.START) {
/*     */       
/*  38 */       GuiScreen gui = mc.field_71462_r;
/*  39 */       if (gui instanceof GuiContainer && !GuiScreen.func_146272_n() && !Mouse.isGrabbed())
/*     */       {
/*  41 */         if (mc.field_71439_g.field_71071_by.func_70445_o() == null) {
/*  42 */           renderMealIngredInGui((GuiContainer)gui, (EntityPlayer)mc.field_71439_g);
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMealIngredInGui(GuiContainer gui, EntityPlayer player) {
/*  49 */     Minecraft mc = FMLClientHandler.instance().getClient();
/*  50 */     ScaledResolution var13 = new ScaledResolution(mc, mc.field_71443_c, mc.field_71440_d);
/*  51 */     int scaledWidth = var13.func_78326_a();
/*  52 */     int scaledHeight = var13.func_78328_b();
/*  53 */     int mouseX = Mouse.getX() * scaledWidth / mc.field_71443_c;
/*  54 */     int mouseY = scaledHeight - Mouse.getY() * scaledHeight / mc.field_71440_d - 1;
/*     */     
/*  56 */     GL11.glPushMatrix();
/*  57 */     GL11.glPushAttrib(1048575);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     int shiftx = -8;
/*  64 */     int shifty = 0;
/*     */     
/*  66 */     Slot slot = gui.func_146975_c(mouseX, mouseY);
/*  67 */     if (slot != null && slot.func_111238_b()) {
/*     */       
/*  69 */       if (slot.func_75216_d() && slot.func_75211_c().func_77973_b() instanceof com.bioxx.tfc.Food.ItemMeal && slot.func_75211_c().func_77942_o()) {
/*     */         
/*  71 */         int[] fg = Food.getFoodGroups(slot.func_75211_c());
/*  72 */         TFC_Core.bindTexture(TextureMap.field_110576_c);
/*  73 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  74 */         for (int i = 0; i < fg.length; i++) {
/*     */           
/*  76 */           Item food = FoodRegistry.getInstance().getFood(fg[i]);
/*  77 */           if (food != null) {
/*     */             
/*  79 */             int x = mouseX + 19;
/*  80 */             int y = mouseY + 11;
/*  81 */             GL11.glDisable(2929);
/*  82 */             GL11.glPushMatrix();
/*  83 */             GL11.glEnable(3042);
/*  84 */             GL11.glBlendFunc(770, 771);
/*  85 */             GL11.glTranslated((x + shiftx - 2), (y + shifty), 0.0D);
/*  86 */             GL11.glScaled(1.0D, 1.0D, 0.0D);
/*  87 */             drawQuad(0, 0, 8, 8, 200.0D, food.func_77617_a(0));
/*  88 */             GL11.glDisable(3042);
/*  89 */             GL11.glPopMatrix();
/*     */             
/*  91 */             shiftx += 8;
/*     */           } 
/*     */         } 
/*  94 */       }  GL11.glEnable(2929);
/*     */     } 
/*     */     
/*  97 */     GL11.glPopAttrib();
/*     */     
/*  99 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawQuad(int x, int y, int xSize, int ySize, double zLevel, IIcon ico) {
/* 104 */     Tessellator var9 = Tessellator.field_78398_a;
/* 105 */     var9.func_78382_b();
/* 106 */     var9.func_78374_a((x + 0), (y + ySize), zLevel, ico.func_94209_e(), ico.func_94210_h());
/* 107 */     var9.func_78374_a((x + xSize), (y + ySize), zLevel, ico.func_94212_f(), ico.func_94210_h());
/* 108 */     var9.func_78374_a((x + xSize), (y + 0), zLevel, ico.func_94212_f(), ico.func_94206_g());
/* 109 */     var9.func_78374_a((x + 0), (y + 0), zLevel, ico.func_94209_e(), ico.func_94206_g());
/* 110 */     var9.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\FMLClientEventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */