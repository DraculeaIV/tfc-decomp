/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.ContainerSkills;
/*     */ import com.bioxx.tfc.Core.Player.SkillStats;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.api.SkillsManager;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class GuiSkills
/*     */   extends GuiContainerTFC
/*     */ {
/*  21 */   public static ResourceLocation texture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_skills.png");
/*     */   
/*     */   protected EntityPlayer player;
/*     */   private int skillsPage;
/*     */   private static final int SKILLS_PER_PAGE = 9;
/*     */   
/*     */   public GuiSkills(EntityPlayer player) {
/*  28 */     super((Container)new ContainerSkills(player), 176, 166);
/*  29 */     setDrawInventory(false);
/*  30 */     this.player = player;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146979_b(int par1, int par2) {
/*  36 */     this.field_146289_q.func_85187_a(TFC_Core.translate("gui.skillpage"), this.field_146999_f / 2 - this.field_146289_q.func_78256_a(TFC_Core.translate("gui.skillpage")) / 2, 4, 4210752, false);
/*  37 */     SkillStats ss = TFC_Core.getSkillStats(this.player);
/*  38 */     int y = 10;
/*  39 */     int count = -1;
/*  40 */     for (SkillsManager.Skill o : SkillsManager.instance.getSkillsArray()) {
/*     */       
/*  42 */       count++;
/*  43 */       if (count < 9 * this.skillsPage + 9 && count >= 9 * this.skillsPage) {
/*     */         
/*  45 */         bindTexture(texture);
/*  46 */         func_73729_b(4, y, 4, 208, 168, 16);
/*  47 */         y += 12;
/*  48 */         float perc = ss.getPercToNextRank(o.skillName);
/*  49 */         func_73729_b(4, y, 4, 168, 168, 4);
/*  50 */         func_73729_b(4, y, 4, 172, (int)Math.floor((168.0F * perc)), 4);
/*     */         
/*  52 */         this.field_146289_q.func_85187_a(TFC_Core.translate(o.skillName) + ": " + EnumChatFormatting.DARK_BLUE + ss.getSkillRank(o.skillName).getLocalizedName(), 6, y - 9, 0, false);
/*  53 */         y += 3;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float f, int i, int j) {
/*  61 */     drawGui(texture);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawGui(ResourceLocation rl) {
/*  67 */     bindTexture(rl);
/*  68 */     this.field_147003_i = (this.field_146294_l - this.field_146999_f) / 2;
/*  69 */     this.field_147009_r = (this.field_146295_m - this.field_147000_g) / 2 - 3;
/*  70 */     func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  76 */     super.func_73866_w_();
/*  77 */     createButtons();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton guibutton) {
/*  83 */     if (guibutton.field_146127_k == 0) {
/*  84 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiInventoryTFC((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g));
/*  85 */     } else if (guibutton.field_146127_k == 2) {
/*  86 */       Minecraft.func_71410_x().func_147108_a(new GuiCalendar((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g));
/*  87 */     } else if (guibutton.field_146127_k == 3) {
/*  88 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiHealth((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g));
/*  89 */     } else if (guibutton.field_146127_k == 4) {
/*     */       
/*  91 */       if (this.skillsPage > 0) {
/*  92 */         this.skillsPage--;
/*     */       }
/*  94 */     } else if (guibutton.field_146127_k == 5) {
/*     */       
/*  96 */       if (9 + this.skillsPage * 9 < SkillsManager.instance.getSkillsArray().size()) {
/*  97 */         this.skillsPage++;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/* 104 */     super.func_73876_c();
/* 105 */     if (this.skillsPage == 0) {
/* 106 */       ((GuiButton)this.field_146292_n.get(4)).field_146124_l = false;
/*     */     } else {
/* 108 */       ((GuiButton)this.field_146292_n.get(4)).field_146124_l = true;
/*     */     } 
/* 110 */     if (9 + this.skillsPage * 9 < SkillsManager.instance.getSkillsArray().size()) {
/* 111 */       ((GuiButton)this.field_146292_n.get(5)).field_146124_l = true;
/*     */     } else {
/* 113 */       ((GuiButton)this.field_146292_n.get(5)).field_146124_l = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void createButtons() {
/* 118 */     this.field_147003_i = (this.field_146294_l - this.field_146999_f) / 2;
/* 119 */     this.field_147009_r = (this.field_146295_m - this.field_147000_g) / 2;
/* 120 */     this.field_146292_n.clear();
/* 121 */     this.field_146292_n.add(new GuiInventoryButton(0, this.field_147003_i + 176, this.field_147009_r, 25, 20, 0, 86, 25, 20, TFC_Core.translate("gui.Inventory.Inventory"), TFC_Textures.guiInventory));
/* 122 */     this.field_146292_n.add(new GuiInventoryButton(1, this.field_147003_i + 176, this.field_147009_r + 19, 25, 20, 0, 86, 25, 20, TFC_Core.translate("gui.Inventory.Skills"), TFC_Textures.guiSkills));
/* 123 */     this.field_146292_n.add(new GuiInventoryButton(2, this.field_147003_i + 176, this.field_147009_r + 38, 25, 20, 0, 86, 25, 20, TFC_Core.translate("gui.Calendar.Calendar"), TFC_Textures.guiCalendar));
/* 124 */     this.field_146292_n.add(new GuiInventoryButton(3, this.field_147003_i + 176, this.field_147009_r + 57, 25, 20, 0, 86, 25, 20, TFC_Core.translate("gui.Inventory.Health"), TFC_Textures.guiHealth));
/* 125 */     this.field_146292_n.add(new GuiButtonPage(4, this.field_147003_i + 4, this.field_147009_r + 144, 30, 15, 0, 177));
/* 126 */     this.field_146292_n.add(new GuiButtonPage(5, this.field_147003_i + 142, this.field_147009_r + 144, 30, 15, 0, 192));
/*     */   }
/*     */   
/*     */   public class GuiButtonPage
/*     */     extends GuiButton {
/*     */     private int u;
/*     */     private int v;
/*     */     
/*     */     public GuiButtonPage(int id, int xPos, int yPos, int xSize, int ySize, int u, int v) {
/* 135 */       super(id, xPos, yPos, xSize, ySize, "");
/* 136 */       this.u = u;
/* 137 */       this.v = v;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_146112_a(Minecraft par1Minecraft, int xPos, int yPos) {
/* 143 */       if (this.field_146125_m) {
/*     */         
/* 145 */         GuiSkills.this.bindTexture(GuiSkills.texture);
/* 146 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 147 */         this.field_146123_n = (xPos >= this.field_146128_h && yPos >= this.field_146129_i && xPos < this.field_146128_h + this.field_146120_f && yPos < this.field_146129_i + this.field_146121_g);
/* 148 */         int k = func_146114_a(this.field_146123_n) - 1;
/* 149 */         func_73729_b(this.field_146128_h, this.field_146129_i, this.u + 30 * k, this.v, this.field_146120_f, this.field_146121_g);
/*     */         
/* 151 */         func_146119_b(par1Minecraft, xPos, yPos);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiSkills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */