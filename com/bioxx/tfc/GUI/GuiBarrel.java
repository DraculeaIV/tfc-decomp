/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.ContainerBarrel;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.api.Crafting.BarrelManager;
/*     */ import com.bioxx.tfc.api.Crafting.BarrelPreservativeRecipe;
/*     */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.Interfaces.IFood;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiBarrel
/*     */   extends GuiContainerTFC
/*     */ {
/*  40 */   public static final ResourceLocation TEXTURE = new ResourceLocation("terrafirmacraft", "textures/gui/gui_barrel.png");
/*     */   
/*     */   protected TEBarrel barrelTE;
/*     */   protected EntityPlayer player;
/*     */   protected int guiTab;
/*     */   
/*     */   public GuiBarrel(InventoryPlayer inventoryplayer, TEBarrel te, World world, int x, int y, int z, int tab) {
/*  47 */     super((Container)new ContainerBarrel(inventoryplayer, te, world, x, y, z, tab), 176, 85);
/*  48 */     this.barrelTE = te;
/*  49 */     this.player = inventoryplayer.field_70458_d;
/*  50 */     this.field_147003_i = (this.field_146294_l - 208) / 2;
/*  51 */     this.field_147009_r = (this.field_146295_m - 198) / 2;
/*  52 */     this.guiTab = tab;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  58 */     super.func_73876_c();
/*  59 */     if (this.barrelTE.getInvCount() > 0) {
/*     */       
/*  61 */       if (this.guiTab == 0) {
/*  62 */         ((GuiButton)this.field_146292_n.get(4)).field_146125_m = false;
/*  63 */       } else if (this.guiTab == 1) {
/*  64 */         ((GuiButton)this.field_146292_n.get(1)).field_146125_m = false;
/*     */       }
/*     */     
/*     */     }
/*  68 */     else if (this.guiTab == 0) {
/*  69 */       ((GuiButton)this.field_146292_n.get(4)).field_146125_m = true;
/*  70 */     } else if (this.guiTab == 1) {
/*  71 */       ((GuiButton)this.field_146292_n.get(1)).field_146125_m = true;
/*     */     } 
/*  73 */     if (this.barrelTE.getFluidLevel() > 0) {
/*     */       
/*  75 */       if (this.guiTab == 0) {
/*  76 */         ((GuiButton)this.field_146292_n.get(3)).field_146125_m = false;
/*  77 */       } else if (this.guiTab == 1) {
/*  78 */         ((GuiButton)this.field_146292_n.get(0)).field_146125_m = false;
/*     */       }
/*     */     
/*     */     }
/*  82 */     else if (this.guiTab == 0) {
/*  83 */       ((GuiButton)this.field_146292_n.get(3)).field_146125_m = true;
/*  84 */     } else if (this.guiTab == 1) {
/*  85 */       ((GuiButton)this.field_146292_n.get(0)).field_146125_m = true;
/*     */     } 
/*     */     
/*  88 */     if (this.barrelTE.getSealed() && this.guiTab == 0) {
/*     */       
/*  90 */       ((GuiButton)this.field_146292_n.get(0)).field_146126_j = TFC_Core.translate("gui.Barrel.Unseal");
/*  91 */       ((GuiButton)this.field_146292_n.get(1)).field_146124_l = false;
/*  92 */       ((GuiButton)this.field_146292_n.get(2)).field_146124_l = false;
/*     */     }
/*  94 */     else if (!this.barrelTE.getSealed() && this.guiTab == 0) {
/*     */       
/*  96 */       ((GuiButton)this.field_146292_n.get(0)).field_146126_j = TFC_Core.translate("gui.Barrel.Seal");
/*  97 */       ((GuiButton)this.field_146292_n.get(1)).field_146124_l = true;
/*  98 */       ((GuiButton)this.field_146292_n.get(2)).field_146124_l = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/* 105 */     super.func_73866_w_();
/* 106 */     createButtons();
/*     */   }
/*     */ 
/*     */   
/*     */   public void createButtons() {
/* 111 */     this.field_146292_n.clear();
/* 112 */     if (this.guiTab == 0) {
/*     */       
/* 114 */       if (!this.barrelTE.getSealed()) {
/* 115 */         this.field_146292_n.add(new GuiButton(0, this.field_147003_i + 38, this.field_147009_r + 50, 50, 20, TFC_Core.translate("gui.Barrel.Seal")));
/*     */       } else {
/* 117 */         this.field_146292_n.add(new GuiButton(0, this.field_147003_i + 38, this.field_147009_r + 50, 50, 20, TFC_Core.translate("gui.Barrel.Unseal")));
/* 118 */       }  this.field_146292_n.add(new GuiButton(1, this.field_147003_i + 88, this.field_147009_r + 50, 50, 20, TFC_Core.translate("gui.Barrel.Empty")));
/* 119 */       if (this.barrelTE.mode == 0) {
/* 120 */         this.field_146292_n.add(new GuiBarrelTabButton(2, this.field_147003_i + 39, this.field_147009_r + 29, 16, 16, this, TFC_Core.translate("gui.Barrel.ToggleOn"), 0, 204, 16, 16));
/* 121 */       } else if (this.barrelTE.mode == 1) {
/* 122 */         this.field_146292_n.add(new GuiBarrelTabButton(2, this.field_147003_i + 39, this.field_147009_r + 29, 16, 16, this, TFC_Core.translate("gui.Barrel.ToggleOff"), 0, 188, 16, 16));
/* 123 */       }  this.field_146292_n.add(new GuiBarrelTabButton(3, this.field_147003_i + 36, this.field_147009_r - 12, 31, 15, this, TFC_Textures.guiSolidStorage, TFC_Core.translate("gui.Barrel.Solid")));
/* 124 */       this.field_146292_n.add(new GuiBarrelTabButton(4, this.field_147003_i + 5, this.field_147009_r - 12, 31, 15, this, TFC_Textures.guiLiquidStorage, TFC_Core.translate("gui.Barrel.Liquid")));
/*     */     
/*     */     }
/* 127 */     else if (this.guiTab == 1) {
/*     */       
/* 129 */       this.field_146292_n.add(new GuiBarrelTabButton(0, this.field_147003_i + 36, this.field_147009_r - 12, 31, 15, this, TFC_Textures.guiSolidStorage, TFC_Core.translate("gui.Barrel.Solid")));
/* 130 */       this.field_146292_n.add(new GuiBarrelTabButton(1, this.field_147003_i + 5, this.field_147009_r - 12, 31, 15, this, TFC_Textures.guiLiquidStorage, TFC_Core.translate("gui.Barrel.Liquid")));
/*     */       
/* 132 */       if (!this.barrelTE.getSealed()) {
/* 133 */         this.field_146292_n.add(new GuiButton(2, this.field_147003_i + 6, this.field_147009_r + 33, 44, 20, TFC_Core.translate("gui.Barrel.Seal")));
/*     */       } else {
/* 135 */         this.field_146292_n.add(new GuiButton(2, this.field_147003_i + 6, this.field_147009_r + 33, 44, 20, TFC_Core.translate("gui.Barrel.Unseal")));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTooltip(int mx, int my, String text) {
/* 142 */     List<String> list = new ArrayList<String>();
/* 143 */     list.add(text);
/* 144 */     drawHoveringText(list, mx, my + 15, this.field_146289_q);
/* 145 */     RenderHelper.func_74518_a();
/* 146 */     GL11.glDisable(2896);
/*     */   }
/*     */   
/*     */   public class GuiButtonMode
/*     */     extends GuiButton
/*     */   {
/*     */     public GuiButtonMode(int par1, int par2, int par3, String par4Str) {
/* 153 */       super(par1, par2, par3, 200, 20, par4Str);
/*     */     }
/*     */ 
/*     */     
/*     */     public GuiButtonMode(int par1, int par2, int par3, int par4, int par5, String par6Str) {
/* 158 */       super(par1, par2, par3, par4, par5, par6Str);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_146112_a(Minecraft par1Minecraft, int xPos, int yPos) {
/* 164 */       if (this.field_146125_m) {
/*     */         
/* 166 */         FontRenderer fontrenderer = par1Minecraft.field_71466_p;
/* 167 */         par1Minecraft.func_110434_K().func_110577_a(field_146122_a);
/* 168 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 169 */         this.field_146123_n = (xPos >= this.field_146128_h && yPos >= this.field_146129_i && xPos < this.field_146128_h + this.field_146120_f && yPos < this.field_146129_i + this.field_146121_g);
/* 170 */         int k = func_146114_a(this.field_146123_n);
/* 171 */         func_73729_b(this.field_146128_h, this.field_146129_i, 0, 46 + k * 20, this.field_146120_f / 2, this.field_146121_g);
/* 172 */         func_73729_b(this.field_146128_h + this.field_146120_f / 2, this.field_146129_i, 200 - this.field_146120_f / 2, 46 + k * 20, this.field_146120_f / 2, this.field_146121_g);
/* 173 */         func_146119_b(par1Minecraft, xPos, yPos);
/* 174 */         int l = 14737632;
/*     */         
/* 176 */         if (!this.field_146124_l) {
/*     */           
/* 178 */           l = -6250336;
/*     */         }
/* 180 */         else if (this.field_146123_n) {
/*     */           
/* 182 */           l = 16777120;
/*     */         } 
/*     */         
/* 185 */         func_73732_a(fontrenderer, (GuiBarrel.this.barrelTE.mode == 0) ? TFC_Core.translate("gui.Barrel.ToggleOn") : TFC_Core.translate("gui.Barrel.ToggleOff"), this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, l);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public class GuiBarrelTabButton
/*     */     extends GuiButton
/*     */   {
/*     */     private GuiBarrel screen;
/*     */     private IIcon buttonicon;
/*     */     private int xPos;
/* 196 */     private int yPos = 172;
/* 197 */     private int xSize = 31;
/* 198 */     private int ySize = 15;
/*     */ 
/*     */     
/*     */     public GuiBarrelTabButton(int index, int xPos, int yPos, int width, int height, GuiBarrel gui, IIcon icon, String s) {
/* 202 */       super(index, xPos, yPos, width, height, s);
/* 203 */       this.screen = gui;
/* 204 */       this.buttonicon = icon;
/*     */     }
/*     */ 
/*     */     
/*     */     public GuiBarrelTabButton(int index, int xPos, int yPos, int width, int height, GuiBarrel gui, String s, int xp, int yp, int xs, int ys) {
/* 209 */       super(index, xPos, yPos, width, height, s);
/* 210 */       this.screen = gui;
/* 211 */       this.xPos = xp;
/* 212 */       this.yPos = yp;
/* 213 */       this.xSize = xs;
/* 214 */       this.ySize = ys;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_146112_a(Minecraft mc, int x, int y) {
/* 220 */       if (this.field_146125_m) {
/*     */         
/* 222 */         TFC_Core.bindTexture(GuiBarrel.TEXTURE);
/* 223 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 224 */         this.field_73735_i = 301.0F;
/* 225 */         func_73729_b(this.field_146128_h, this.field_146129_i, this.xPos, this.yPos, this.xSize, this.ySize);
/* 226 */         this.field_146123_n = (x >= this.field_146128_h && y >= this.field_146129_i && x < this.field_146128_h + this.field_146120_f && y < this.field_146129_i + this.field_146121_g);
/*     */         
/* 228 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 229 */         TFC_Core.bindTexture(TextureMap.field_110575_b);
/* 230 */         if (this.buttonicon != null) {
/* 231 */           func_94065_a(this.field_146128_h + 12, this.field_146129_i + 4, this.buttonicon, 8, 8);
/*     */         }
/* 233 */         this.field_73735_i = 0.0F;
/* 234 */         func_146119_b(mc, x, y);
/*     */         
/* 236 */         if (this.field_146123_n) {
/*     */           
/* 238 */           this.screen.drawTooltip(x, y, this.field_146126_j);
/* 239 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton guibutton) {
/* 248 */     if (this.guiTab == 0) {
/*     */       
/* 250 */       if (guibutton.field_146127_k == 0) {
/*     */         
/* 252 */         if (!this.barrelTE.getSealed()) {
/* 253 */           this.barrelTE.actionSeal(0, this.player);
/*     */         } else {
/* 255 */           this.barrelTE.actionUnSeal(0, this.player);
/*     */         } 
/* 257 */       } else if (guibutton.field_146127_k == 1) {
/* 258 */         this.barrelTE.actionEmpty();
/* 259 */       } else if (guibutton.field_146127_k == 2) {
/*     */         
/* 261 */         this.barrelTE.actionMode();
/* 262 */         createButtons();
/*     */       }
/* 264 */       else if (guibutton.field_146127_k == 3 && this.barrelTE.getFluidLevel() == 0 && this.barrelTE.getInvCount() == 0) {
/* 265 */         this.barrelTE.actionSwitchTab(1, this.player);
/*     */       } 
/* 267 */     } else if (this.guiTab == 1) {
/*     */       
/* 269 */       if (guibutton.field_146127_k == 1 && this.barrelTE.getInvCount() == 0) {
/* 270 */         this.barrelTE.actionSwitchTab(0, this.player);
/* 271 */       } else if (guibutton.field_146127_k == 2) {
/*     */         
/* 273 */         if (!this.barrelTE.getSealed()) {
/* 274 */           this.barrelTE.actionSeal(1, this.player);
/*     */         } else {
/* 276 */           this.barrelTE.actionUnSeal(1, this.player);
/* 277 */         }  createButtons();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float f, int mouseX, int mouseY) {
/* 288 */     bindTexture(TEXTURE);
/* 289 */     this.field_147003_i = (this.field_146294_l - this.field_146999_f) / 2;
/* 290 */     this.field_147009_r = (this.field_146295_m - this.field_147000_g) / 2;
/*     */     
/* 292 */     if (this.guiTab == 0) {
/*     */       
/* 294 */       func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, getShiftedYSize());
/*     */       
/* 296 */       int scale = 0;
/* 297 */       if (this.barrelTE != null && this.barrelTE.fluid != null) {
/*     */         
/* 299 */         scale = this.barrelTE.getLiquidScaled(50);
/*     */         
/* 301 */         IIcon liquidIcon = this.barrelTE.fluid.getFluid().getIcon(this.barrelTE.fluid);
/* 302 */         TFC_Core.bindTexture(TextureMap.field_110575_b);
/* 303 */         int color = this.barrelTE.fluid.getFluid().getColor(this.barrelTE.fluid);
/* 304 */         GL11.glColor4ub((byte)(color >> 16 & 0xFF), (byte)(color >> 8 & 0xFF), (byte)(color & 0xFF), (byte)-86);
/* 305 */         int div = (int)Math.floor((scale / 8));
/* 306 */         int rem = scale - div * 8;
/* 307 */         func_94065_a(this.field_147003_i + 12, this.field_147009_r + 65 - scale, liquidIcon, 8, (div > 0) ? 8 : rem);
/* 308 */         for (int c = 0; div > 0 && c < div; c++)
/*     */         {
/* 310 */           func_94065_a(this.field_147003_i + 12, this.field_147009_r + 65 - 8 + c * 8, liquidIcon, 8, 8);
/*     */         }
/* 312 */         GL11.glColor3f(0.0F, 0.0F, 0.0F);
/*     */       } 
/* 314 */       ItemStack inStack = this.barrelTE.func_70301_a(0);
/*     */ 
/*     */       
/* 317 */       if (this.barrelTE.getFluidStack() != null) {
/* 318 */         func_73732_a(this.field_146289_q, this.barrelTE.fluid.getFluid().getLocalizedName(this.barrelTE.getFluidStack()), this.field_147003_i + 88, this.field_147009_r + 7, 5592405);
/*     */       }
/*     */       
/* 321 */       if (this.barrelTE.sealtime != 0)
/*     */       {
/* 323 */         func_73732_a(this.field_146289_q, TFC_Time.getDateStringFromHours(this.barrelTE.sealtime), this.field_147003_i + 88, this.field_147009_r + 17, 5592405);
/*     */       }
/*     */ 
/*     */       
/* 327 */       if (this.barrelTE.recipe != null) {
/*     */         
/* 329 */         if (!(this.barrelTE.recipe instanceof com.bioxx.tfc.api.Crafting.BarrelBriningRecipe))
/*     */         {
/* 331 */           func_73732_a(this.field_146289_q, TFC_Core.translate("gui.Output") + ": " + this.barrelTE.recipe.getRecipeName(), this.field_147003_i + 88, this.field_147009_r + 72, 5592405);
/*     */         }
/* 333 */         else if (this.barrelTE.getSealed() && this.barrelTE.getFluidStack() != null && this.barrelTE.getFluidStack().getFluid() == TFCFluids.BRINE)
/*     */         {
/* 335 */           if (inStack != null && inStack.func_77973_b() instanceof IFood && (((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Fruit || ((IFood)inStack
/* 336 */             .func_77973_b()).getFoodGroup() == EnumFoodGroup.Vegetable || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Protein || (IFood)inStack
/* 337 */             .func_77973_b() == TFCItems.cheese) && !Food.isBrined(inStack))
/*     */           {
/* 339 */             func_73732_a(this.field_146289_q, TFC_Core.translate("gui.barrel.brining"), this.field_147003_i + 88, this.field_147009_r + 72, 5592405);
/*     */           }
/*     */         }
/*     */       
/* 343 */       } else if (this.barrelTE.recipe == null && this.barrelTE.getSealed() && this.barrelTE.getFluidStack() != null && inStack != null && inStack.func_77973_b() instanceof IFood && this.barrelTE
/* 344 */         .getFluidStack().getFluid() == TFCFluids.VINEGAR && !Food.isPickled(inStack) && Food.getWeight(inStack) / (this.barrelTE.getFluidStack()).amount <= 160.0F / this.barrelTE.getMaxLiquid()) {
/*     */         
/* 346 */         if ((((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Fruit || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Vegetable || ((IFood)inStack
/* 347 */           .func_77973_b()).getFoodGroup() == EnumFoodGroup.Protein || (IFood)inStack.func_77973_b() == TFCItems.cheese) && 
/* 348 */           Food.isBrined(inStack))
/*     */         {
/* 350 */           func_73732_a(this.field_146289_q, TFC_Core.translate("gui.barrel.pickling"), this.field_147003_i + 88, this.field_147009_r + 72, 5592405);
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 355 */         BarrelPreservativeRecipe preservative = BarrelManager.getInstance().findMatchingPreservativeRepice(this.barrelTE, inStack, this.barrelTE.getFluidStack(), this.barrelTE.getSealed());
/* 356 */         if (preservative != null) {
/* 357 */           func_73732_a(this.field_146289_q, TFC_Core.translate(preservative.getPreservingString()), this.field_147003_i + 88, this.field_147009_r + 72, 5592405);
/*     */         }
/*     */       }
/*     */     
/*     */     }
/* 362 */     else if (this.guiTab == 1) {
/*     */       
/* 364 */       func_73729_b(this.field_147003_i, this.field_147009_r, 0, 86, this.field_146999_f, getShiftedYSize());
/*     */     } 
/*     */     
/* 367 */     PlayerInventory.drawInventory(this, this.field_146294_l, this.field_146295_m, getShiftedYSize());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146979_b(int mouseX, int mouseY) {
/* 373 */     if (this.guiTab == 0 && mouseInRegion(12, 15, 9, 50, mouseX, mouseY)) {
/*     */       
/* 375 */       ArrayList<String> list = new ArrayList<String>();
/* 376 */       list.add(this.barrelTE.getFluidLevel() + "mB");
/* 377 */       drawHoveringText(list, mouseX - this.field_147003_i, mouseY - this.field_147009_r + 8, this.field_146289_q);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73732_a(FontRenderer fontrenderer, String s, int i, int j, int k) {
/* 384 */     fontrenderer.func_78276_b(s, i - fontrenderer.func_78256_a(s) / 2, j, k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int x, int y, float par3) {
/* 390 */     super.func_73863_a(x, y, par3);
/* 391 */     if (this.barrelTE.getSealed()) {
/*     */       
/* 393 */       GL11.glPushMatrix();
/* 394 */       if (this.guiTab == 0) {
/*     */         
/* 396 */         Slot inputSlot = this.field_147002_h.func_75139_a(0);
/* 397 */         drawSlotOverlay(inputSlot);
/*     */       }
/* 399 */       else if (this.guiTab == 1) {
/*     */         
/* 401 */         for (int i = 0; i < this.barrelTE.storage.length; i++) {
/*     */           
/* 403 */           Slot slot = this.field_147002_h.func_75139_a(i);
/* 404 */           drawSlotOverlay(slot);
/*     */         } 
/*     */       } 
/*     */       
/* 408 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawSlotOverlay(Slot slot) {
/* 414 */     GL11.glDisable(2896);
/* 415 */     GL11.glDisable(2929);
/* 416 */     int xPos = slot.field_75223_e + this.field_147003_i - 1;
/* 417 */     int yPos = slot.field_75221_f + this.field_147009_r - 1;
/* 418 */     GL11.glColorMask(true, true, true, false);
/* 419 */     func_73733_a(xPos, yPos, xPos + 18, yPos + 18, 1979711487, 1979711487);
/* 420 */     GL11.glColorMask(true, true, true, true);
/* 421 */     GL11.glEnable(2896);
/* 422 */     GL11.glEnable(2929);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiBarrel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */