/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.ContainerFoodPrep;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEFoodPrep;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class GuiFoodPrep
/*     */   extends GuiContainerTFC
/*     */ {
/*  23 */   private static final ResourceLocation TEXTURE = new ResourceLocation("terrafirmacraft", "textures/gui/gui_foodprep.png");
/*     */   
/*     */   private TEFoodPrep foodPrepTE;
/*     */   private int guiTab;
/*     */   
/*     */   public GuiFoodPrep(InventoryPlayer inventoryplayer, TEFoodPrep te, World world, int i, int j, int k, int tab) {
/*  29 */     super((Container)new ContainerFoodPrep(inventoryplayer, te, world, i, j, k, tab), 176, 85);
/*  30 */     this.foodPrepTE = te;
/*  31 */     this.guiTab = tab;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float f, int i, int j) {
/*  40 */     bindTexture(TEXTURE);
/*  41 */     this.field_147003_i = (this.field_146294_l - this.field_146999_f) / 2;
/*  42 */     this.field_147009_r = (this.field_146295_m - this.field_147000_g) / 2;
/*  43 */     if (this.guiTab == 0) {
/*     */       
/*  45 */       func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, getShiftedYSize());
/*     */     }
/*  47 */     else if (this.guiTab == 1) {
/*     */       
/*  49 */       func_73729_b(this.field_147003_i, this.field_147009_r, 0, 86, this.field_146999_f, getShiftedYSize());
/*     */     } 
/*     */     
/*  52 */     PlayerInventory.drawInventory(this, this.field_146294_l, this.field_146295_m, getShiftedYSize());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  58 */     super.func_73866_w_();
/*  59 */     this.field_146292_n.clear();
/*  60 */     if (this.guiTab == 0) {
/*     */       
/*  62 */       this.field_146292_n.add(new GuiButton(0, this.field_147003_i + 74, this.field_147009_r + 44, 50, 20, TFC_Core.translate("gui.FoodPrep.CreateMeal")));
/*  63 */       this.field_146292_n.add((new GuiFoodPrepTabButton(2, this.field_147003_i + 36, this.field_147009_r - 21, 31, 21, this, new ItemStack(TFCItems.salad), TFC_Core.translate("gui.FoodPrep.Salad"))).setButtonCoord(31, 172));
/*  64 */       this.field_146292_n.add(new GuiFoodPrepTabButton(1, this.field_147003_i + 5, this.field_147009_r - 21, 31, 21, this, new ItemStack(TFCItems.sandwich), TFC_Core.translate("gui.FoodPrep.Sandwich")));
/*     */     }
/*  66 */     else if (this.guiTab == 1) {
/*     */       
/*  68 */       this.field_146292_n.add(new GuiButton(0, this.field_147003_i + 74, this.field_147009_r + 44, 50, 20, TFC_Core.translate("gui.FoodPrep.CreateMeal")));
/*  69 */       this.field_146292_n.add(new GuiFoodPrepTabButton(2, this.field_147003_i + 36, this.field_147009_r - 21, 31, 21, this, new ItemStack(TFCItems.salad), TFC_Core.translate("gui.FoodPrep.Salad")));
/*  70 */       this.field_146292_n.add((new GuiFoodPrepTabButton(1, this.field_147003_i + 5, this.field_147009_r - 21, 31, 21, this, new ItemStack(TFCItems.sandwich), TFC_Core.translate("gui.FoodPrep.Sandwich"))).setButtonCoord(31, 172));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton guibutton) {
/*  77 */     if (guibutton.field_146127_k == 0) {
/*  78 */       this.foodPrepTE.actionCreate((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g);
/*  79 */     } else if (guibutton.field_146127_k == 1 && this.guiTab != 0) {
/*  80 */       this.foodPrepTE.actionSwitchTab(0, (EntityPlayer)(Minecraft.func_71410_x()).field_71439_g);
/*  81 */     } else if (guibutton.field_146127_k == 2 && this.guiTab != 1) {
/*  82 */       this.foodPrepTE.actionSwitchTab(1, (EntityPlayer)(Minecraft.func_71410_x()).field_71439_g);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  88 */     super.func_73876_c();
/*  89 */     if (this.guiTab == 0 && this.foodPrepTE.validateSandwich()) {
/*  90 */       ((GuiButton)this.field_146292_n.get(0)).field_146124_l = true;
/*  91 */     } else if (this.guiTab == 1 && this.foodPrepTE.validateSalad()) {
/*  92 */       ((GuiButton)this.field_146292_n.get(0)).field_146124_l = true;
/*  93 */     } else if (((GuiButton)this.field_146292_n.get(0)).field_146124_l) {
/*  94 */       ((GuiButton)this.field_146292_n.get(0)).field_146124_l = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public class GuiFoodPrepTabButton
/*     */     extends GuiButton
/*     */   {
/*     */     private GuiFoodPrep screen;
/*     */     private ItemStack item;
/*     */     private int xPos;
/* 104 */     private int yPos = 172;
/* 105 */     private int xSize = 31;
/* 106 */     private int ySize = 24;
/*     */ 
/*     */     
/*     */     public GuiFoodPrepTabButton(int index, int xPos, int yPos, int width, int height, GuiFoodPrep gui, ItemStack is, String s) {
/* 110 */       super(index, xPos, yPos, width, height, s);
/* 111 */       this.screen = gui;
/* 112 */       this.item = is;
/*     */     }
/*     */ 
/*     */     
/*     */     public GuiFoodPrepTabButton(int index, int xPos, int yPos, int width, int height, GuiFoodPrep gui, String s, int xp, int yp, int xs, int ys) {
/* 117 */       super(index, xPos, yPos, width, height, s);
/* 118 */       this.screen = gui;
/* 119 */       this.xPos = xp;
/* 120 */       this.yPos = yp;
/* 121 */       this.xSize = xs;
/* 122 */       this.ySize = ys;
/*     */     }
/*     */ 
/*     */     
/*     */     public GuiFoodPrepTabButton setButtonCoord(int x, int y) {
/* 127 */       this.xPos = x;
/* 128 */       this.yPos = y;
/* 129 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_146112_a(Minecraft mc, int x, int y) {
/* 135 */       if (this.field_146125_m) {
/*     */ 
/*     */ 
/*     */         
/* 139 */         TFC_Core.bindTexture(GuiFoodPrep.TEXTURE);
/* 140 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 141 */         RenderHelper.func_74518_a();
/* 142 */         GL11.glDisable(2896);
/* 143 */         GL11.glDisable(2929);
/* 144 */         this.field_73735_i = 301.0F;
/* 145 */         func_73729_b(this.field_146128_h, this.field_146129_i, this.xPos, this.yPos, this.xSize, this.ySize);
/* 146 */         this.field_146123_n = (x >= this.field_146128_h && y >= this.field_146129_i && x < this.field_146128_h + this.field_146120_f && y < this.field_146129_i + this.field_146121_g);
/*     */         
/* 148 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 149 */         GL11.glPushMatrix();
/* 150 */         renderInventorySlot(this.item, this.field_146128_h + 8, this.field_146129_i + 5);
/* 151 */         GL11.glPopMatrix();
/* 152 */         func_146119_b(mc, x, y);
/*     */         
/* 154 */         if (this.field_146123_n) {
/*     */           
/* 156 */           this.screen.drawTooltip(x, y, this.field_146126_j);
/* 157 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renderInventorySlot(ItemStack par1, int par2, int par3) {
/* 164 */       if (par1 != null)
/*     */       {
/* 166 */         RenderItem.getInstance().func_82406_b((Minecraft.func_71410_x()).field_71466_p, Minecraft.func_71410_x().func_110434_K(), par1, par2, par3);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiFoodPrep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */