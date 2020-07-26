/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.Handlers.Network.ItemRenamePacket;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiCustomNametag
/*     */   extends GuiScreen
/*     */ {
/*     */   private GuiTextField theGuiTextField;
/*     */   private World world;
/*     */   private EntityPlayer player;
/*  32 */   protected int xSize = 220;
/*     */ 
/*     */   
/*  35 */   protected int ySize = 104;
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
/*     */   public GuiCustomNametag(EntityPlayer p, World world, int i, int j, int k) {
/*  48 */     this.world = world;
/*  49 */     this.guiLeft = (this.field_146294_l - this.xSize) / 2;
/*  50 */     this.guiTop = (this.field_146295_m - this.ySize) / 2;
/*     */ 
/*     */     
/*  53 */     this.player = p;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  59 */     this.theGuiTextField.func_146178_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/*  65 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  71 */     super.func_73866_w_();
/*     */     
/*  73 */     this.guiTop = (this.field_146295_m - this.ySize) / 2;
/*     */     
/*  75 */     Keyboard.enableRepeatEvents(true);
/*  76 */     this.field_146292_n.clear();
/*  77 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.guiTop + 57, TFC_Core.translate("gui.done")));
/*     */ 
/*     */     
/*  80 */     this.theGuiTextField = new GuiTextField(this.field_146289_q, this.field_146294_l / 2 - 90, this.guiTop + 27, 180, 20);
/*  81 */     this.theGuiTextField.func_146195_b(true);
/*  82 */     this.theGuiTextField.func_146180_a("");
/*     */   }
/*     */   
/*  85 */   public static RenderItem itemRenderer = new RenderItem();
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int par1, int par2, int par3) {
/*  90 */     super.func_73864_a(par1, par2, par3);
/*  91 */     this.theGuiTextField.func_146192_a(par1, par2, par3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char par1, int par2) {
/*  97 */     this.theGuiTextField.func_146201_a(par1, par2);
/*  98 */     ((GuiButton)this.field_146292_n.get(0)).field_146124_l = (this.theGuiTextField.func_146179_b().trim().length() > 0);
/*  99 */     if (par1 == '\r') {
/* 100 */       func_146284_a(this.field_146292_n.get(0));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73732_a(FontRenderer fontrenderer, String s, int i, int j, int k) {
/* 112 */     fontrenderer.func_78276_b(s, i - fontrenderer.func_78256_a(s) / 2, j, k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton guibutton) {
/* 118 */     if (guibutton.field_146127_k == 0 && this.world.field_72995_K) {
/*     */       
/* 120 */       ItemStack stack = this.player.field_71071_by.func_70448_g();
/* 121 */       stack.field_77990_d.func_74778_a("Name", this.theGuiTextField.func_146179_b());
/*     */       
/* 123 */       ItemRenamePacket itemRenamePacket = new ItemRenamePacket(this.theGuiTextField.func_146179_b());
/*     */       
/* 125 */       TerraFirmaCraft.PACKET_PIPELINE.sendToServer((AbstractPacket)itemRenamePacket);
/*     */       
/* 127 */       Minecraft.func_71410_x().func_147108_a(null);
/*     */     }
/* 129 */     else if (guibutton.field_146127_k == 1 && this.world.field_72995_K) {
/*     */       
/* 131 */       Minecraft.func_71410_x().func_147108_a(null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int par1, int par2, float par3) {
/* 138 */     TFC_Core.bindTexture(new ResourceLocation("terrafirmacraft", "textures/gui/gui_nametag.png"));
/*     */     
/* 140 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 141 */     int l = (this.field_146294_l - this.xSize) / 2;
/* 142 */     int i1 = (this.field_146295_m - this.ySize) / 2;
/* 143 */     func_73729_b(l, i1, 0, 0, this.xSize, this.ySize);
/*     */     
/* 145 */     func_73732_a(this.field_146289_q, TFC_Core.translate("gui.Nametag"), this.field_146294_l / 2, i1 + 8, 0);
/* 146 */     this.theGuiTextField.func_146194_f();
/*     */     
/* 148 */     super.func_73863_a(par1, par2, par3);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiCustomNametag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */