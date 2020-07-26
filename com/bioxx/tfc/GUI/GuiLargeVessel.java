/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.ContainerLargeVessel;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.TileEntities.TEVessel;
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
/*     */ public class GuiLargeVessel
/*     */   extends GuiContainerTFC
/*     */ {
/*  41 */   public static final ResourceLocation TEXTURE = new ResourceLocation("terrafirmacraft", "textures/gui/gui_largevessel.png");
/*     */   
/*     */   private TEVessel vesselTE;
/*     */   private EntityPlayer player;
/*     */   private int guiTab;
/*     */   
/*     */   public GuiLargeVessel(InventoryPlayer inventoryplayer, TEVessel te, World world, int x, int y, int z, int tab) {
/*  48 */     super((Container)new ContainerLargeVessel(inventoryplayer, te, world, x, y, z, tab), 176, 85);
/*  49 */     this.vesselTE = te;
/*  50 */     this.player = inventoryplayer.field_70458_d;
/*  51 */     this.field_147003_i = (this.field_146294_l - 208) / 2;
/*  52 */     this.field_147009_r = (this.field_146295_m - 198) / 2;
/*  53 */     this.guiTab = tab;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  59 */     super.func_73876_c();
/*  60 */     if (this.vesselTE.getInvCount() > 0) {
/*     */       
/*  62 */       if (this.guiTab == 0) {
/*  63 */         ((GuiButton)this.field_146292_n.get(4)).field_146125_m = false;
/*  64 */       } else if (this.guiTab == 1) {
/*  65 */         ((GuiButton)this.field_146292_n.get(1)).field_146125_m = false;
/*     */       }
/*     */     
/*     */     }
/*  69 */     else if (this.guiTab == 0) {
/*  70 */       ((GuiButton)this.field_146292_n.get(4)).field_146125_m = true;
/*  71 */     } else if (this.guiTab == 1) {
/*  72 */       ((GuiButton)this.field_146292_n.get(1)).field_146125_m = true;
/*     */     } 
/*  74 */     if (this.vesselTE.getFluidLevel() > 0) {
/*     */       
/*  76 */       if (this.guiTab == 0) {
/*  77 */         ((GuiButton)this.field_146292_n.get(3)).field_146125_m = false;
/*  78 */       } else if (this.guiTab == 1) {
/*  79 */         ((GuiButton)this.field_146292_n.get(0)).field_146125_m = false;
/*     */       }
/*     */     
/*     */     }
/*  83 */     else if (this.guiTab == 0) {
/*  84 */       ((GuiButton)this.field_146292_n.get(3)).field_146125_m = true;
/*  85 */     } else if (this.guiTab == 1) {
/*  86 */       ((GuiButton)this.field_146292_n.get(0)).field_146125_m = true;
/*     */     } 
/*     */     
/*  89 */     if (this.vesselTE.getSealed() && this.guiTab == 0) {
/*     */       
/*  91 */       ((GuiButton)this.field_146292_n.get(0)).field_146126_j = TFC_Core.translate("gui.Barrel.Unseal");
/*  92 */       ((GuiButton)this.field_146292_n.get(1)).field_146124_l = false;
/*  93 */       ((GuiButton)this.field_146292_n.get(2)).field_146124_l = false;
/*     */     }
/*  95 */     else if (!this.vesselTE.getSealed() && this.guiTab == 0) {
/*     */       
/*  97 */       ((GuiButton)this.field_146292_n.get(0)).field_146126_j = TFC_Core.translate("gui.Barrel.Seal");
/*  98 */       ((GuiButton)this.field_146292_n.get(1)).field_146124_l = true;
/*  99 */       ((GuiButton)this.field_146292_n.get(2)).field_146124_l = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/* 106 */     super.func_73866_w_();
/* 107 */     createButtons();
/*     */   }
/*     */ 
/*     */   
/*     */   public void createButtons() {
/* 112 */     this.field_146292_n.clear();
/* 113 */     if (this.guiTab == 0) {
/*     */       
/* 115 */       if (!this.vesselTE.getSealed()) {
/* 116 */         this.field_146292_n.add(new GuiButton(0, this.field_147003_i + 38, this.field_147009_r + 50, 50, 20, TFC_Core.translate("gui.Barrel.Seal")));
/*     */       } else {
/* 118 */         this.field_146292_n.add(new GuiButton(0, this.field_147003_i + 38, this.field_147009_r + 50, 50, 20, TFC_Core.translate("gui.Barrel.Unseal")));
/* 119 */       }  this.field_146292_n.add(new GuiButton(1, this.field_147003_i + 88, this.field_147009_r + 50, 50, 20, TFC_Core.translate("gui.Barrel.Empty")));
/* 120 */       if (this.vesselTE.mode == 0) {
/* 121 */         this.field_146292_n.add(new GuiBarrelTabButton(2, this.field_147003_i + 39, this.field_147009_r + 29, 16, 16, this, TFC_Core.translate("gui.Barrel.ToggleOn"), 0, 204, 16, 16));
/* 122 */       } else if (this.vesselTE.mode == 1) {
/* 123 */         this.field_146292_n.add(new GuiBarrelTabButton(2, this.field_147003_i + 39, this.field_147009_r + 29, 16, 16, this, TFC_Core.translate("gui.Barrel.ToggleOff"), 0, 188, 16, 16));
/* 124 */       }  this.field_146292_n.add(new GuiBarrelTabButton(3, this.field_147003_i + 36, this.field_147009_r - 12, 31, 15, this, TFC_Textures.guiSolidStorage, TFC_Core.translate("gui.Barrel.Solid")));
/* 125 */       this.field_146292_n.add(new GuiBarrelTabButton(4, this.field_147003_i + 5, this.field_147009_r - 12, 31, 15, this, TFC_Textures.guiLiquidStorage, TFC_Core.translate("gui.Barrel.Liquid")));
/*     */     
/*     */     }
/* 128 */     else if (this.guiTab == 1) {
/*     */       
/* 130 */       this.field_146292_n.add(new GuiBarrelTabButton(0, this.field_147003_i + 36, this.field_147009_r - 12, 31, 15, this, TFC_Textures.guiSolidStorage, TFC_Core.translate("gui.Barrel.Solid")));
/* 131 */       this.field_146292_n.add(new GuiBarrelTabButton(1, this.field_147003_i + 5, this.field_147009_r - 12, 31, 15, this, TFC_Textures.guiLiquidStorage, TFC_Core.translate("gui.Barrel.Liquid")));
/*     */       
/* 133 */       if (!this.vesselTE.getSealed()) {
/* 134 */         this.field_146292_n.add(new GuiButton(2, this.field_147003_i + 6, this.field_147009_r + 33, 44, 20, TFC_Core.translate("gui.Barrel.Seal")));
/*     */       } else {
/* 136 */         this.field_146292_n.add(new GuiButton(2, this.field_147003_i + 6, this.field_147009_r + 33, 44, 20, TFC_Core.translate("gui.Barrel.Unseal")));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTooltip(int mx, int my, String text) {
/* 143 */     List<String> list = new ArrayList<String>();
/* 144 */     list.add(text);
/* 145 */     drawHoveringText(list, mx, my + 15, this.field_146289_q);
/* 146 */     RenderHelper.func_74518_a();
/* 147 */     GL11.glDisable(2896);
/*     */   }
/*     */   
/*     */   public class GuiButtonMode
/*     */     extends GuiButton
/*     */   {
/*     */     public GuiButtonMode(int par1, int par2, int par3, String par4Str) {
/* 154 */       super(par1, par2, par3, 200, 20, par4Str);
/*     */     }
/*     */ 
/*     */     
/*     */     public GuiButtonMode(int par1, int par2, int par3, int par4, int par5, String par6Str) {
/* 159 */       super(par1, par2, par3, par4, par5, par6Str);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_146112_a(Minecraft par1Minecraft, int xPos, int yPos) {
/* 165 */       if (this.field_146125_m) {
/*     */         
/* 167 */         FontRenderer fontrenderer = par1Minecraft.field_71466_p;
/* 168 */         par1Minecraft.func_110434_K().func_110577_a(field_146122_a);
/* 169 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 170 */         this.field_146123_n = (xPos >= this.field_146128_h && yPos >= this.field_146129_i && xPos < this.field_146128_h + this.field_146120_f && yPos < this.field_146129_i + this.field_146121_g);
/* 171 */         int k = func_146114_a(this.field_146123_n);
/* 172 */         func_73729_b(this.field_146128_h, this.field_146129_i, 0, 46 + k * 20, this.field_146120_f / 2, this.field_146121_g);
/* 173 */         func_73729_b(this.field_146128_h + this.field_146120_f / 2, this.field_146129_i, 200 - this.field_146120_f / 2, 46 + k * 20, this.field_146120_f / 2, this.field_146121_g);
/* 174 */         func_146119_b(par1Minecraft, xPos, yPos);
/* 175 */         int l = 14737632;
/*     */         
/* 177 */         if (!this.field_146124_l) {
/*     */           
/* 179 */           l = -6250336;
/*     */         }
/* 181 */         else if (this.field_146123_n) {
/*     */           
/* 183 */           l = 16777120;
/*     */         } 
/*     */         
/* 186 */         func_73732_a(fontrenderer, (GuiLargeVessel.this.vesselTE.mode == 0) ? TFC_Core.translate("gui.Barrel.ToggleOn") : TFC_Core.translate("gui.Barrel.ToggleOff"), this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, l);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public class GuiBarrelTabButton
/*     */     extends GuiButton
/*     */   {
/*     */     private GuiLargeVessel screen;
/*     */     private IIcon buttonicon;
/*     */     private int xPos;
/* 197 */     private int yPos = 172;
/* 198 */     private int xSize = 31;
/* 199 */     private int ySize = 15;
/*     */ 
/*     */     
/*     */     public GuiBarrelTabButton(int index, int xPos, int yPos, int width, int height, GuiLargeVessel gui, IIcon icon, String s) {
/* 203 */       super(index, xPos, yPos, width, height, s);
/* 204 */       this.screen = gui;
/* 205 */       this.buttonicon = icon;
/*     */     }
/*     */ 
/*     */     
/*     */     public GuiBarrelTabButton(int index, int xPos, int yPos, int width, int height, GuiLargeVessel gui, String s, int xp, int yp, int xs, int ys) {
/* 210 */       super(index, xPos, yPos, width, height, s);
/* 211 */       this.screen = gui;
/* 212 */       this.xPos = xp;
/* 213 */       this.yPos = yp;
/* 214 */       this.xSize = xs;
/* 215 */       this.ySize = ys;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_146112_a(Minecraft mc, int x, int y) {
/* 221 */       if (this.field_146125_m) {
/*     */         
/* 223 */         TFC_Core.bindTexture(GuiLargeVessel.TEXTURE);
/* 224 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 225 */         this.field_73735_i = 301.0F;
/* 226 */         func_73729_b(this.field_146128_h, this.field_146129_i, this.xPos, this.yPos, this.xSize, this.ySize);
/* 227 */         this.field_146123_n = (x >= this.field_146128_h && y >= this.field_146129_i && x < this.field_146128_h + this.field_146120_f && y < this.field_146129_i + this.field_146121_g);
/*     */         
/* 229 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 230 */         TFC_Core.bindTexture(TextureMap.field_110575_b);
/* 231 */         if (this.buttonicon != null) {
/* 232 */           func_94065_a(this.field_146128_h + 12, this.field_146129_i + 4, this.buttonicon, 8, 8);
/*     */         }
/* 234 */         this.field_73735_i = 0.0F;
/* 235 */         func_146119_b(mc, x, y);
/*     */         
/* 237 */         if (this.field_146123_n) {
/*     */           
/* 239 */           this.screen.drawTooltip(x, y, this.field_146126_j);
/* 240 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton guibutton) {
/* 249 */     if (this.guiTab == 0) {
/*     */       
/* 251 */       if (guibutton.field_146127_k == 0) {
/*     */         
/* 253 */         if (!this.vesselTE.getSealed()) {
/* 254 */           this.vesselTE.actionSeal(0, this.player);
/*     */         } else {
/* 256 */           this.vesselTE.actionUnSeal(0, this.player);
/*     */         } 
/* 258 */       } else if (guibutton.field_146127_k == 1) {
/* 259 */         this.vesselTE.actionEmpty();
/* 260 */       } else if (guibutton.field_146127_k == 2) {
/*     */         
/* 262 */         this.vesselTE.actionMode();
/* 263 */         createButtons();
/*     */       }
/* 265 */       else if (guibutton.field_146127_k == 3 && this.vesselTE.getFluidLevel() == 0 && this.vesselTE.getInvCount() == 0) {
/* 266 */         this.vesselTE.actionSwitchTab(1, this.player);
/*     */       } 
/* 268 */     } else if (this.guiTab == 1) {
/*     */       
/* 270 */       if (guibutton.field_146127_k == 1 && this.vesselTE.getInvCount() == 0) {
/* 271 */         this.vesselTE.actionSwitchTab(0, this.player);
/* 272 */       } else if (guibutton.field_146127_k == 2) {
/*     */         
/* 274 */         if (!this.vesselTE.getSealed()) {
/* 275 */           this.vesselTE.actionSeal(1, this.player);
/*     */         } else {
/* 277 */           this.vesselTE.actionUnSeal(1, this.player);
/* 278 */         }  createButtons();
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
/* 289 */     TFC_Core.bindTexture(TEXTURE);
/* 290 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
/* 291 */     int w = (this.field_146294_l - this.field_146999_f) / 2;
/* 292 */     int h = (this.field_146295_m - this.field_147000_g) / 2;
/* 293 */     if (this.guiTab == 0) {
/*     */       
/* 295 */       func_73729_b(w, h, 0, 0, this.field_146999_f, getShiftedYSize());
/*     */       
/* 297 */       int scale = 0;
/* 298 */       if (this.vesselTE != null && this.vesselTE.fluid != null) {
/*     */         
/* 300 */         scale = this.vesselTE.getLiquidScaled(50);
/*     */         
/* 302 */         IIcon liquidIcon = this.vesselTE.fluid.getFluid().getIcon(this.vesselTE.fluid);
/* 303 */         TFC_Core.bindTexture(TextureMap.field_110575_b);
/* 304 */         int color = this.vesselTE.fluid.getFluid().getColor(this.vesselTE.fluid);
/* 305 */         GL11.glColor4ub((byte)(color >> 16 & 0xFF), (byte)(color >> 8 & 0xFF), (byte)(color & 0xFF), (byte)-86);
/* 306 */         int div = (int)Math.floor((scale / 8));
/* 307 */         int rem = scale - div * 8;
/* 308 */         func_94065_a(w + 12, h + 65 - scale, liquidIcon, 8, (div > 0) ? 8 : rem);
/* 309 */         for (int c = 0; div > 0 && c < div; c++)
/*     */         {
/* 311 */           func_94065_a(w + 12, h + 65 - 8 + c * 8, liquidIcon, 8, 8);
/*     */         }
/* 313 */         GL11.glColor3f(0.0F, 0.0F, 0.0F);
/*     */       } 
/* 315 */       ItemStack inStack = this.vesselTE.func_70301_a(0);
/*     */ 
/*     */       
/* 318 */       if (this.vesselTE.getFluidStack() != null) {
/* 319 */         func_73732_a(this.field_146289_q, this.vesselTE.fluid.getFluid().getLocalizedName(this.vesselTE.getFluidStack()), this.field_147003_i + 88, this.field_147009_r + 7, 5592405);
/*     */       }
/*     */       
/* 322 */       if (this.vesselTE.sealtime != 0)
/*     */       {
/* 324 */         func_73732_a(this.field_146289_q, TFC_Time.getDateStringFromHours(this.vesselTE.sealtime), this.field_147003_i + 88, this.field_147009_r + 17, 5592405);
/*     */       }
/*     */ 
/*     */       
/* 328 */       if (this.vesselTE.recipe != null) {
/*     */         
/* 330 */         if (!(this.vesselTE.recipe instanceof com.bioxx.tfc.api.Crafting.BarrelBriningRecipe))
/*     */         {
/* 332 */           func_73732_a(this.field_146289_q, TFC_Core.translate("gui.Output") + ": " + this.vesselTE.recipe.getRecipeName(), this.field_147003_i + 88, this.field_147009_r + 72, 5592405);
/*     */         }
/* 334 */         else if (this.vesselTE.getSealed() && this.vesselTE.getFluidStack() != null && this.vesselTE.getFluidStack().getFluid() == TFCFluids.BRINE)
/*     */         {
/* 336 */           if (inStack != null && inStack.func_77973_b() instanceof IFood && (((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Fruit || ((IFood)inStack
/* 337 */             .func_77973_b()).getFoodGroup() == EnumFoodGroup.Vegetable || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Protein || (IFood)inStack
/* 338 */             .func_77973_b() == TFCItems.cheese) && !Food.isBrined(inStack))
/*     */           {
/* 340 */             func_73732_a(this.field_146289_q, TFC_Core.translate("gui.barrel.brining"), this.field_147003_i + 88, this.field_147009_r + 72, 5592405);
/*     */           }
/*     */         }
/*     */       
/* 344 */       } else if (this.vesselTE.recipe == null && this.vesselTE.getSealed() && this.vesselTE.getFluidStack() != null && inStack != null && inStack.func_77973_b() instanceof IFood && this.vesselTE
/* 345 */         .getFluidStack().getFluid() == TFCFluids.VINEGAR && !Food.isPickled(inStack) && Food.getWeight(inStack) / (this.vesselTE.getFluidStack()).amount <= 160.0F / this.vesselTE.getMaxLiquid()) {
/*     */         
/* 347 */         if ((((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Fruit || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Vegetable || ((IFood)inStack
/* 348 */           .func_77973_b()).getFoodGroup() == EnumFoodGroup.Protein || (IFood)inStack.func_77973_b() == TFCItems.cheese) && 
/* 349 */           Food.isBrined(inStack))
/*     */         {
/* 351 */           func_73732_a(this.field_146289_q, TFC_Core.translate("gui.barrel.pickling"), this.field_147003_i + 88, this.field_147009_r + 72, 5592405);
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 356 */         BarrelPreservativeRecipe preservative = BarrelManager.getInstance().findMatchingPreservativeRepice((TEBarrel)this.vesselTE, inStack, this.vesselTE.getFluidStack(), this.vesselTE.getSealed());
/* 357 */         if (preservative != null) {
/* 358 */           func_73732_a(this.field_146289_q, TFC_Core.translate(preservative.getPreservingString()), this.field_147003_i + 88, this.field_147009_r + 72, 5592405);
/*     */         }
/*     */       }
/*     */     
/* 362 */     } else if (this.guiTab == 1) {
/*     */       
/* 364 */       func_73729_b(w, h, 0, 86, this.field_146999_f, getShiftedYSize());
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
/* 376 */       list.add(this.vesselTE.getFluidLevel() + "mB");
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
/* 391 */     if (this.vesselTE.getSealed()) {
/*     */       
/* 393 */       GL11.glPushMatrix();
/* 394 */       if (this.guiTab == 0) {
/*     */         
/* 396 */         Slot inputSlot = this.field_147002_h.func_75139_a(0);
/* 397 */         drawSlotOverlay(inputSlot);
/*     */       }
/* 399 */       else if (this.guiTab == 1) {
/*     */         
/* 401 */         for (int i = 0; i < this.vesselTE.storage.length; i++) {
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


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiLargeVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */