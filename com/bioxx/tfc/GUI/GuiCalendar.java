/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiCalendar
/*     */   extends GuiScreen
/*     */ {
/*     */   private World world;
/*     */   private EntityPlayer player;
/*  23 */   private static final ResourceLocation TEXTURE = new ResourceLocation("terrafirmacraft:textures/gui/gui_calendar.png");
/*     */ 
/*     */   
/*  26 */   protected int xSize = 176;
/*     */ 
/*     */   
/*  29 */   protected int ySize = 184;
/*     */ 
/*     */ 
/*     */   
/*     */   protected int guiLeft;
/*     */ 
/*     */ 
/*     */   
/*     */   protected int guiTop;
/*     */ 
/*     */ 
/*     */   
/*     */   public GuiCalendar(EntityPlayer p) {
/*  42 */     this.world = p.field_70170_p;
/*  43 */     this.guiLeft = (this.field_146294_l - this.xSize) / 2;
/*  44 */     this.guiTop = (this.field_146295_m - this.ySize) / 2;
/*  45 */     this.player = p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  57 */     super.func_73866_w_();
/*  58 */     this.field_146292_n.clear();
/*  59 */     this.guiLeft = (this.field_146294_l - this.xSize) / 2;
/*  60 */     this.guiTop = (this.field_146295_m - this.ySize) / 2;
/*  61 */     if (TFCOptions.enableDebugMode) {
/*     */       
/*  63 */       this.field_146292_n.add(new GuiButton(0, this.guiLeft + 20, this.guiTop + 118, 66, 20, TFC_Core.translate("gui.Calendar.1Hour")));
/*  64 */       this.field_146292_n.add(new GuiButton(1, this.guiLeft + 20, this.guiTop + 137, 66, 20, TFC_Core.translate("gui.Calendar.1Day")));
/*  65 */       this.field_146292_n.add(new GuiButton(2, this.guiLeft + 85, this.guiTop + 118, 66, 20, TFC_Core.translate("gui.Calendar.1Month")));
/*  66 */       this.field_146292_n.add(new GuiButton(3, this.guiLeft + 85, this.guiTop + 137, 66, 20, TFC_Core.translate("gui.Calendar.1Year")));
/*     */     } 
/*     */     
/*  69 */     this.field_146292_n.add(new GuiInventoryButton(4, this.guiLeft + 176, this.guiTop + 9, 25, 20, 0, 86, 25, 20, 
/*  70 */           TFC_Core.translate("gui.Inventory.Inventory"), TFC_Textures.guiInventory));
/*  71 */     this.field_146292_n.add(new GuiInventoryButton(5, this.guiLeft + 176, this.guiTop + 28, 25, 20, 0, 86, 25, 20, 
/*  72 */           TFC_Core.translate("gui.Inventory.Skills"), TFC_Textures.guiSkills));
/*  73 */     this.field_146292_n.add(new GuiInventoryButton(6, this.guiLeft + 176, this.guiTop + 47, 25, 20, 0, 86, 25, 20, 
/*  74 */           TFC_Core.translate("gui.Calendar.Calendar"), TFC_Textures.guiCalendar));
/*  75 */     this.field_146292_n.add(new GuiInventoryButton(7, this.guiLeft + 176, this.guiTop + 66, 25, 20, 0, 86, 25, 20, 
/*  76 */           TFC_Core.translate("gui.Inventory.Health"), TFC_Textures.guiHealth));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int par1, int par2, float par3) {
/*  83 */     func_146270_b(0);
/*     */     
/*  85 */     TFC_Core.bindTexture(TEXTURE);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  91 */     int l = (this.field_146294_l - this.xSize) / 2;
/*  92 */     int i1 = (this.field_146295_m - this.ySize) / 2;
/*  93 */     func_73729_b(l, i1 + 6, 0, 0, this.xSize, this.ySize);
/*     */     
/*  95 */     func_73732_a(this.field_146289_q, TFC_Core.translate("gui.Calendar.Calendar"), l + 87, i1 + 16, 16777215);
/*  96 */     func_73732_a(this.field_146289_q, TFC_Core.translate("gui.Calendar.Season") + " : " + TFC_Time.SEASONS[TFC_Time.getSeasonAdjustedMonth((int)this.player.field_70161_v)], l + 87, i1 + 26, 0);
/*     */     
/*  98 */     int dom = TFC_Time.getDayOfMonth();
/*  99 */     int month = TFC_Time.currentMonth;
/* 100 */     String day = TFC_Time.DAYS[TFC_Time.getDayOfWeek()];
/*     */     
/* 102 */     if (month == 3 && dom == 18) {
/* 103 */       day = TFC_Core.translate("gui.Calendar.DateKitty");
/* 104 */     } else if (month == 4 && dom == 7) {
/* 105 */       day = TFC_Core.translate("gui.Calendar.DateBioxx");
/* 106 */     } else if (month == 8 && dom == 2) {
/* 107 */       day = TFC_Core.translate("gui.Calendar.DateDunk");
/*     */     } 
/* 109 */     func_73732_a(this.field_146289_q, TFC_Core.translate("gui.Calendar.Day") + " : " + day, l + 87, i1 + 36, 0);
/*     */     
/* 111 */     int year = 1000 + TFC_Time.getYear();
/*     */     
/* 113 */     if (month >= 10) {
/* 114 */       year++;
/*     */     }
/* 116 */     func_73732_a(this.field_146289_q, TFC_Core.translate("gui.Calendar.Date") + " : " + dom + " " + TFC_Time.MONTHS[month] + ", " + year, l + 87, i1 + 46, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 124 */     long h = TFC_Time.getHour();
/* 125 */     String hour = "";
/* 126 */     if (h == 0L) {
/* 127 */       hour = TFC_Core.translate("gui.Calendar.WitchHour");
/*     */     } else {
/* 129 */       hour = hour + h;
/* 130 */     }  func_73732_a(this.field_146289_q, TFC_Core.translate("gui.Calendar.Hour") + " : " + hour, l + 87, i1 + 56, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     for (int var6 = 0; var6 < this.field_146292_n.size(); var6++) {
/*     */       
/* 138 */       GuiButton var7 = this.field_146292_n.get(var6);
/* 139 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 140 */       var7.func_146112_a(this.field_146297_k, par1, par2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 147 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char par1, int par2) {
/* 153 */     if (par2 == 1 || par2 == this.field_146297_k.field_71474_y.field_151445_Q.func_151463_i()) {
/* 154 */       this.field_146297_k.field_71439_g.func_71053_j();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73732_a(FontRenderer fontrenderer, String s, int i, int j, int k) {
/* 160 */     fontrenderer.func_78276_b(s, i - fontrenderer.func_78256_a(s) / 2, j, k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton guibutton) {
/* 166 */     if (this.world.field_72995_K)
/* 167 */       if (guibutton.field_146127_k == 0) {
/* 168 */         this.field_146297_k.field_71439_g.func_71165_d("/time add 1000");
/* 169 */       } else if (guibutton.field_146127_k == 1) {
/* 170 */         this.field_146297_k.field_71439_g.func_71165_d("/time add 24000");
/* 171 */       } else if (guibutton.field_146127_k == 2) {
/* 172 */         this.field_146297_k.field_71439_g.func_71165_d("/time add " + (24000 * TFC_Time.daysInMonth));
/* 173 */       } else if (guibutton.field_146127_k == 3) {
/* 174 */         this.field_146297_k.field_71439_g.func_71165_d("/time add " + (24000 * TFC_Time.daysInYear));
/* 175 */       } else if (guibutton.field_146127_k == 4) {
/* 176 */         this.field_146297_k.func_147108_a((GuiScreen)new GuiInventoryTFC((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g));
/* 177 */       } else if (guibutton.field_146127_k == 5) {
/* 178 */         Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiSkills((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g));
/* 179 */       } else if (guibutton.field_146127_k == 7) {
/* 180 */         Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiHealth((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g));
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiCalendar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */