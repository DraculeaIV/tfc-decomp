/*     */ package com.bioxx.tfc.Handlers.Client;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*     */ import com.bioxx.tfc.Core.Player.InventoryPlayerTFC;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Items.ItemQuiver;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.api.TFCAttributes;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.Tools.ChiselManager;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.relauncher.ReflectionHelper;
/*     */ import java.awt.Color;
/*     */ import java.lang.reflect.Field;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiIngame;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.GuiIngameForge;
/*     */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderOverlayHandler
/*     */ {
/*  51 */   public static ResourceLocation tfcicons = new ResourceLocation("terrafirmacraft", "textures/gui/icons.png");
/*     */   private FontRenderer fontrenderer;
/*     */   public int recordTimer;
/*  54 */   private final Field _recordPlayingUpFor = ReflectionHelper.findField(GuiIngame.class, new String[] { "recordPlayingUpFor", "field_73845_h" });
/*  55 */   private final Field _recordPlaying = ReflectionHelper.findField(GuiIngame.class, new String[] { "recordPlaying", "field_73838_g" });
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void renderText(RenderGameOverlayEvent.Chat event) {
/*  61 */     if ((Minecraft.func_71410_x()).field_71442_b.func_78758_h()) {
/*  62 */       event.posY += 4;
/*     */     } else {
/*  64 */       event.posY -= 12;
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void render(RenderGameOverlayEvent.Pre event) {
/*  70 */     GuiIngameForge.renderFood = false;
/*     */ 
/*     */     
/*  73 */     if (event.type != RenderGameOverlayEvent.ElementType.CROSSHAIRS) {
/*     */       return;
/*     */     }
/*     */     
/*  77 */     GuiIngameForge.right_height += 10;
/*     */     
/*  79 */     ScaledResolution sr = event.resolution;
/*  80 */     Minecraft mc = Minecraft.func_71410_x();
/*  81 */     EntityClientPlayerMP entityClientPlayerMP = mc.field_71439_g;
/*  82 */     InventoryPlayer playerInventory = ((EntityPlayer)entityClientPlayerMP).field_71071_by;
/*  83 */     PlayerInfo playerInfo = PlayerManagerTFC.getInstance().getClientPlayer();
/*     */     
/*  85 */     int healthRowHeight = sr.func_78328_b() - 40;
/*  86 */     int armorRowHeight = healthRowHeight - 10;
/*  87 */     int mid = sr.func_78326_a() / 2;
/*     */     
/*  89 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  90 */     TFC_Core.bindTexture(tfcicons);
/*     */ 
/*     */     
/*  93 */     if (TFCOptions.enableToolModeIndicator && playerInventory.func_70448_g() != null && playerInfo != null) {
/*     */       
/*  95 */       Item currentItem = playerInventory.func_70448_g().func_77973_b();
/*     */       
/*  97 */       if (currentItem instanceof com.bioxx.tfc.Items.Tools.ItemCustomHoe) {
/*     */         
/*  99 */         int mode = playerInfo.hoeMode;
/* 100 */         drawTexturedModalRect(mid + 95, sr.func_78328_b() - 21, 0 + 20 * mode, 38, 20, 20);
/*     */       }
/* 102 */       else if (currentItem instanceof com.bioxx.tfc.Items.Tools.ItemChisel) {
/*     */         
/* 104 */         boolean hasHammer = false;
/*     */         
/* 106 */         for (int i = 0; i < 9; i++) {
/*     */           
/* 108 */           if (playerInventory.field_70462_a[i] != null && playerInventory.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemHammer) {
/*     */             
/* 110 */             hasHammer = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 114 */         if (hasHammer) {
/*     */           
/* 116 */           int mode = playerInfo.chiselMode;
/* 117 */           TFC_Core.bindTexture(ChiselManager.getInstance().getResourceLocation(mode));
/* 118 */           drawTexturedModalRect(mid + 95, sr.func_78328_b() - 21, ChiselManager.getInstance().getTextureU(mode), ChiselManager.getInstance().getTextureV(mode), 20, 20);
/* 119 */           TFC_Core.bindTexture(tfcicons);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 125 */     ItemStack quiverStack = getQuiver();
/* 126 */     Item quiver = (quiverStack != null) ? quiverStack.func_77973_b() : null;
/* 127 */     if (quiver instanceof ItemQuiver) {
/*     */       
/* 129 */       this.fontrenderer = mc.field_71466_p;
/*     */       
/* 131 */       int xPos = 1;
/* 132 */       int yPos = sr.func_78328_b() - 34;
/* 133 */       boolean leftSide = true;
/*     */       
/* 135 */       String pos = TFCOptions.quiverHUDPosition;
/*     */       
/* 137 */       if ("topright".equalsIgnoreCase(pos)) {
/*     */         
/* 139 */         xPos = sr.func_78326_a() - 19;
/* 140 */         yPos = 1;
/* 141 */         leftSide = false;
/*     */       }
/* 143 */       else if ("right".equalsIgnoreCase(pos)) {
/*     */         
/* 145 */         xPos = sr.func_78326_a() - 19;
/* 146 */         yPos = (sr.func_78328_b() - 34) / 2;
/* 147 */         leftSide = false;
/*     */       }
/* 149 */       else if ("bottomright".equalsIgnoreCase(pos)) {
/*     */         
/* 151 */         xPos = sr.func_78326_a() - 19;
/* 152 */         yPos = sr.func_78328_b() - 34;
/* 153 */         leftSide = false;
/*     */       }
/* 155 */       else if ("topleft".equalsIgnoreCase(pos)) {
/*     */         
/* 157 */         xPos = 1;
/* 158 */         yPos = 1;
/* 159 */         leftSide = true;
/*     */       }
/* 161 */       else if ("left".equalsIgnoreCase(pos)) {
/*     */         
/* 163 */         xPos = 1;
/* 164 */         yPos = (sr.func_78328_b() - 34) / 2;
/* 165 */         leftSide = true;
/*     */       } 
/*     */       
/* 168 */       drawTexturedModalRect(xPos, yPos, 0, 78, 16, 16);
/* 169 */       drawTexturedModalRect(xPos, yPos + 17, 0, 94, 16, 16);
/*     */       
/* 171 */       if (leftSide) {
/*     */         
/* 173 */         this.fontrenderer.func_78276_b(Integer.toString(getQuiverArrows()), xPos + 19, yPos + 4, Color.white.getRGB());
/* 174 */         this.fontrenderer.func_78276_b(Integer.toString(getQuiverJavelins()), xPos + 19, yPos + 21, Color.white.getRGB());
/*     */       }
/*     */       else {
/*     */         
/* 178 */         int arrowOffset = this.fontrenderer.func_78256_a(String.valueOf(getQuiverArrows())) + 1;
/* 179 */         int javOffset = this.fontrenderer.func_78256_a(String.valueOf(getQuiverJavelins())) + 1;
/*     */         
/* 181 */         this.fontrenderer.func_78276_b(Integer.toString(getQuiverArrows()), xPos - arrowOffset, yPos + 4, Color.white.getRGB());
/* 182 */         this.fontrenderer.func_78276_b(Integer.toString(getQuiverJavelins()), xPos - javOffset, yPos + 21, Color.white.getRGB());
/*     */       } 
/*     */       
/* 185 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 186 */       TFC_Core.bindTexture(tfcicons);
/*     */     } 
/*     */     
/* 189 */     if (mc.field_71442_b.func_78763_f()) {
/*     */ 
/*     */       
/* 192 */       drawTexturedModalRect(mid - 91, healthRowHeight, 0, 0, 90, 10);
/* 193 */       float maxHealth = entityClientPlayerMP.func_110138_aP();
/* 194 */       float percentHealth = Math.min(entityClientPlayerMP.func_110143_aJ() / maxHealth, 1.0F);
/* 195 */       drawTexturedModalRect(mid - 91, healthRowHeight, 0, 10, (int)(90.0F * percentHealth), 10);
/*     */ 
/*     */       
/* 198 */       FoodStatsTFC foodstats = TFC_Core.getPlayerFoodStats((EntityPlayer)entityClientPlayerMP);
/* 199 */       float foodLevel = foodstats.getFoodLevel();
/*     */ 
/*     */       
/* 202 */       float waterLevel = foodstats.waterLevel;
/*     */       
/* 204 */       float percentFood = Math.min(foodLevel / foodstats.getMaxStomach((EntityPlayer)entityClientPlayerMP), 1.0F);
/* 205 */       float percentWater = Math.min(waterLevel / foodstats.getMaxWater((EntityPlayer)entityClientPlayerMP), 1.0F);
/*     */       
/* 207 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 208 */       drawTexturedModalRect(mid + 1, healthRowHeight, 0, 20, 90, 5);
/* 209 */       if (playerInfo != null && playerInfo.guishowFoodRestoreAmount) {
/*     */         
/* 211 */         float percentFood2 = Math.min(percentFood + playerInfo.guiFoodRestoreAmount / foodstats.getMaxStomach((EntityPlayer)entityClientPlayerMP), 1.0F);
/* 212 */         GL11.glColor4f(0.0F, 0.6F, 0.0F, 0.3F);
/* 213 */         drawTexturedModalRect(mid + 1, healthRowHeight, 0, 25, (int)(90.0F * percentFood2), 5);
/*     */       } 
/* 215 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       
/* 217 */       drawTexturedModalRect(mid + 1, healthRowHeight, 0, 25, (int)(90.0F * percentFood), 5);
/*     */       
/* 219 */       drawTexturedModalRect(mid + 1, healthRowHeight + 5, 90, 20, 90, 5);
/* 220 */       drawTexturedModalRect(mid + 1, healthRowHeight + 5, 90, 25, (int)(90.0F * percentWater), 5);
/*     */ 
/*     */       
/* 223 */       String healthString = (int)Math.min(entityClientPlayerMP.func_110143_aJ(), maxHealth) + "/" + (int)maxHealth;
/* 224 */       mc.field_71466_p.func_78276_b(healthString, mid - 45 - mc.field_71466_p.func_78256_a(healthString) / 2, healthRowHeight + 2, Color.white.getRGB());
/* 225 */       if (entityClientPlayerMP.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111127_a(TFCAttributes.OVERBURDENED_UUID) != null) {
/* 226 */         mc.field_71466_p.func_78276_b(TFC_Core.translate("gui.overburdened"), mid - mc.field_71466_p.func_78256_a(TFC_Core.translate("gui.overburdened")) / 2, healthRowHeight - 20, Color.red.getRGB());
/*     */       }
/* 228 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 229 */       TFC_Core.bindTexture(new ResourceLocation("minecraft:textures/gui/icons.png"));
/*     */ 
/*     */       
/* 232 */       if (!(((EntityPlayer)entityClientPlayerMP).field_70154_o instanceof net.minecraft.entity.EntityLiving) || ((EntityPlayer)entityClientPlayerMP).field_70154_o instanceof com.bioxx.tfc.Entities.Mobs.EntityPigTFC) {
/*     */         
/* 234 */         int cap = 0;
/* 235 */         cap = entityClientPlayerMP.func_71050_bK();
/* 236 */         int left = mid - 91;
/*     */         
/* 238 */         if (cap > 0) {
/*     */           
/* 240 */           short barWidth = 182;
/* 241 */           int filled = (int)(((EntityPlayer)entityClientPlayerMP).field_71106_cc * (barWidth + 1));
/* 242 */           int top = sr.func_78328_b() - 29;
/* 243 */           drawTexturedModalRect(left, top, 0, 64, barWidth, 5);
/* 244 */           if (filled > 0) {
/* 245 */             drawTexturedModalRect(left, top, 0, 69, filled, 5);
/*     */           }
/*     */         } 
/* 248 */         if (((EntityPlayer)entityClientPlayerMP).field_71068_ca > 0) {
/*     */           
/* 250 */           this.fontrenderer = mc.field_71466_p;
/* 251 */           boolean flag1 = false;
/* 252 */           int color = flag1 ? 16777215 : 8453920;
/* 253 */           String text = Integer.toString(((EntityPlayer)entityClientPlayerMP).field_71068_ca);
/* 254 */           int x = (sr.func_78326_a() - this.fontrenderer.func_78256_a(text)) / 2;
/* 255 */           int y = sr.func_78328_b() - 30;
/* 256 */           this.fontrenderer.func_78276_b(text, x + 1, y, 0);
/* 257 */           this.fontrenderer.func_78276_b(text, x - 1, y, 0);
/* 258 */           this.fontrenderer.func_78276_b(text, x, y + 1, 0);
/* 259 */           this.fontrenderer.func_78276_b(text, x, y - 1, 0);
/* 260 */           this.fontrenderer.func_78276_b(text, x, y, color);
/*     */         } 
/*     */ 
/*     */         
/* 264 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       } 
/*     */ 
/*     */       
/* 268 */       if (mc.field_71462_r instanceof com.bioxx.tfc.GUI.GuiScreenHorseInventoryTFC) {
/*     */         
/* 270 */         this.recordTimer = 0;
/*     */         
/*     */         try {
/* 273 */           this._recordPlayingUpFor.setInt(mc.field_71456_v, 0);
/* 274 */         } catch (Exception e) {
/*     */           
/* 276 */           throw new RuntimeException(e);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 281 */       if (((EntityPlayer)entityClientPlayerMP).field_70154_o instanceof EntityLivingBase) {
/*     */         
/* 283 */         GuiIngameForge.renderHealthMount = false;
/* 284 */         TFC_Core.bindTexture(tfcicons);
/* 285 */         EntityLivingBase mount = (EntityLivingBase)((EntityPlayer)entityClientPlayerMP).field_70154_o;
/* 286 */         drawTexturedModalRect(mid + 1, armorRowHeight, 90, 0, 90, 10);
/* 287 */         double mountMaxHealth = mount.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b();
/* 288 */         double mountCurrentHealth = mount.func_110143_aJ();
/* 289 */         float mountPercentHealth = (float)Math.min(mountCurrentHealth / mountMaxHealth, 1.0D);
/* 290 */         drawTexturedModalRect(mid + 1, armorRowHeight, 90, 10, (int)(90.0F * mountPercentHealth), 10);
/*     */         
/* 292 */         String mountHealthString = (int)Math.min(mountCurrentHealth, mountMaxHealth) + "/" + (int)mountMaxHealth;
/* 293 */         mc.field_71466_p.func_78276_b(mountHealthString, mid + 47 - mc.field_71466_p.func_78256_a(mountHealthString) / 2, armorRowHeight + 2, Color.white.getRGB());
/* 294 */         renderDismountOverlay(mc, mid, sr.func_78328_b(), event.partialTicks);
/*     */       } 
/*     */       
/* 297 */       TFC_Core.bindTexture(new ResourceLocation("minecraft:textures/gui/icons.png"));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderDismountOverlay(Minecraft mc, int midpoint, int height, float partialTicks) {
/* 309 */     if (this.recordTimer == 0) {
/*     */       
/*     */       try {
/*     */         
/* 313 */         this.recordTimer = this._recordPlayingUpFor.getInt(mc.field_71456_v);
/* 314 */         this._recordPlayingUpFor.setInt(mc.field_71456_v, 0);
/*     */       }
/* 316 */       catch (Exception e) {
/*     */         
/* 318 */         throw new RuntimeException(e);
/*     */       } 
/*     */     }
/*     */     
/* 322 */     if (this.recordTimer > 0) {
/*     */       
/* 324 */       float hue = this.recordTimer - partialTicks;
/* 325 */       int opacity = (int)(hue * 256.0F / 20.0F);
/* 326 */       if (opacity > 255) {
/* 327 */         opacity = 255;
/*     */       }
/* 329 */       if (opacity > 0) {
/*     */         
/*     */         try {
/*     */           
/* 333 */           String recordPlaying = (String)this._recordPlaying.get(mc.field_71456_v);
/*     */           
/* 335 */           GL11.glPushMatrix();
/* 336 */           GL11.glTranslatef(midpoint, (height - 48), 0.0F);
/* 337 */           GL11.glEnable(3042);
/* 338 */           OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 339 */           mc.field_71466_p.func_78276_b(recordPlaying, -mc.field_71466_p.func_78256_a(recordPlaying) / 2, -12, 0xFFFFFF | opacity << 24);
/* 340 */           GL11.glDisable(3042);
/* 341 */           GL11.glPopMatrix();
/*     */         }
/* 343 */         catch (Exception e) {
/*     */           
/* 345 */           throw new RuntimeException(e);
/*     */         } 
/*     */       }
/*     */       
/* 349 */       this.recordTimer--;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void renderText(RenderGameOverlayEvent.Text event) {
/* 356 */     Minecraft mc = Minecraft.func_71410_x();
/* 357 */     if (mc.field_71474_y.field_74330_P || TFCOptions.enableDebugMode) {
/*     */       
/* 359 */       EntityClientPlayerMP entityClientPlayerMP = mc.field_71439_g;
/* 360 */       int xCoord = (int)((EntityPlayer)entityClientPlayerMP).field_70165_t;
/* 361 */       int yCoord = (int)((EntityPlayer)entityClientPlayerMP).field_70163_u;
/* 362 */       int zCoord = (int)((EntityPlayer)entityClientPlayerMP).field_70161_v;
/* 363 */       DataLayer evt = TFC_Climate.getCacheManager((World)mc.field_71441_e).getEVTLayerAt(xCoord, zCoord);
/* 364 */       event.left.add(String.format("rain: %.0f, temp: %.2f, average bio temp: %.2f, evt: %.3f", new Object[] {
/* 365 */               Float.valueOf(TFC_Climate.getRainfall((World)mc.field_71441_e, xCoord, yCoord, zCoord)), 
/* 366 */               Float.valueOf(TFC_Climate.getHeightAdjustedTemp((World)mc.field_71441_e, xCoord, yCoord, zCoord)), 
/* 367 */               Float.valueOf(TFC_Climate.getBioTemperatureHeight((World)mc.field_71441_e, xCoord, yCoord, zCoord)), 
/* 368 */               Float.valueOf(evt.floatdata1)
/*     */             }));
/* 370 */       if (TFCOptions.enableDebugMode) {
/*     */         
/* 372 */         event.left.add("Stability: " + TFC_Climate.getStability((World)mc.field_71441_e, xCoord, zCoord) + ", Drainage: " + 
/* 373 */             TFC_Climate.getCacheManager((World)mc.field_71441_e).getDrainageLayerAt(xCoord, zCoord).getName() + ", pH: " + 
/* 374 */             TFC_Climate.getCacheManager((World)mc.field_71441_e).getPHLayerAt(xCoord, zCoord).getName());
/* 375 */         event.left.add("Rock Layers: " + TFC_Climate.getCacheManager((World)mc.field_71441_e).getRockLayerAt(xCoord, zCoord, 0).getName() + ", " + 
/* 376 */             TFC_Climate.getCacheManager((World)mc.field_71441_e).getRockLayerAt(xCoord, zCoord, 1).getName() + ", " + 
/* 377 */             TFC_Climate.getCacheManager((World)mc.field_71441_e).getRockLayerAt(xCoord, zCoord, 2).getName());
/* 378 */         event.left.add("Tree Layers: " + TFC_Climate.getCacheManager((World)mc.field_71441_e).getTreeLayerAt(xCoord, zCoord, 0).getName() + ", " + 
/* 379 */             TFC_Climate.getCacheManager((World)mc.field_71441_e).getTreeLayerAt(xCoord, zCoord, 1).getName() + ", " + 
/* 380 */             TFC_Climate.getCacheManager((World)mc.field_71441_e).getTreeLayerAt(xCoord, zCoord, 2).getName());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack getQuiver() {
/* 387 */     Minecraft mc = Minecraft.func_71410_x();
/* 388 */     EntityClientPlayerMP entityClientPlayerMP = mc.field_71439_g;
/* 389 */     ItemStack quiver = null;
/* 390 */     if (((EntityPlayer)entityClientPlayerMP).field_71071_by instanceof InventoryPlayerTFC) {
/* 391 */       quiver = ((InventoryPlayerTFC)((EntityPlayer)entityClientPlayerMP).field_71071_by).extraEquipInventory[0];
/*     */     }
/* 393 */     return quiver;
/*     */   }
/*     */ 
/*     */   
/*     */   private int getQuiverArrows() {
/* 398 */     return ((ItemQuiver)TFCItems.quiver).getQuiverArrows(getQuiver());
/*     */   }
/*     */ 
/*     */   
/*     */   private int getQuiverJavelins() {
/* 403 */     return ((ItemQuiver)TFCItems.quiver).getQuiverJavelins(getQuiver());
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {
/* 408 */     float f = 0.00390625F;
/* 409 */     float f1 = 0.00390625F;
/* 410 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 411 */     tessellator.func_78382_b();
/* 412 */     tessellator.func_78374_a((par1 + 0), (par2 + par6), 0.0D, ((par3 + 0) * f), ((par4 + par6) * f1));
/* 413 */     tessellator.func_78374_a((par1 + par5), (par2 + par6), 0.0D, ((par3 + par5) * f), ((par4 + par6) * f1));
/* 414 */     tessellator.func_78374_a((par1 + par5), (par2 + 0), 0.0D, ((par3 + par5) * f), ((par4 + 0) * f1));
/* 415 */     tessellator.func_78374_a((par1 + 0), (par2 + 0), 0.0D, ((par3 + 0) * f), ((par4 + 0) * f1));
/* 416 */     tessellator.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\RenderOverlayHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */