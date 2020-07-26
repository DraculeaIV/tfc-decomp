/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.ContainerCreativeTFC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.gui.achievement.GuiAchievements;
/*     */ import net.minecraft.client.gui.achievement.GuiStats;
/*     */ import net.minecraft.client.gui.inventory.CreativeCrafting;
/*     */ import net.minecraft.client.renderer.InventoryEffectRenderer;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryBasic;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiContainerCreativeTFC
/*     */   extends InventoryEffectRenderer {
/*  45 */   private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
/*  46 */   private static InventoryBasic inventory = new InventoryBasic("tmp", true, 51);
/*     */ 
/*     */   
/*  49 */   private static int selectedTabIndex = CreativeTabs.field_78030_b.func_78021_a();
/*     */ 
/*     */   
/*     */   private float currentScroll;
/*     */ 
/*     */   
/*     */   private boolean isScrolling;
/*     */ 
/*     */   
/*     */   private boolean wasClicking;
/*     */   
/*     */   private GuiTextField searchField;
/*     */   
/*     */   private List<Slot> backupContainerSlots;
/*     */   
/*     */   private Slot zeroSlot;
/*     */   
/*     */   private boolean eventTriggered;
/*     */   
/*     */   private CreativeCrafting crafting;
/*     */   
/*     */   private static int tabPage;
/*     */   
/*     */   private int maxPages;
/*     */ 
/*     */   
/*     */   public GuiContainerCreativeTFC(EntityPlayer par1EntityPlayer) {
/*  76 */     super((Container)new ContainerCreativeTFC(par1EntityPlayer));
/*     */     
/*  78 */     par1EntityPlayer.field_71070_bA = this.field_147002_h;
/*  79 */     this.field_146291_p = true;
/*  80 */     par1EntityPlayer.func_71064_a((StatBase)AchievementList.field_76004_f, 1);
/*  81 */     this.field_147000_g = 136;
/*  82 */     this.field_146999_f = 195;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  91 */     if (!this.field_146297_k.field_71442_b.func_78758_h()) {
/*  92 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiInventoryTFC((EntityPlayer)this.field_146297_k.field_71439_g));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146984_a(Slot par1Slot, int par2, int par3, int par4) {
/*  98 */     this.eventTriggered = true;
/*  99 */     boolean flag = (par4 == 1);
/* 100 */     par4 = (par2 == -999 && par4 == 0) ? 4 : par4;
/*     */ 
/*     */ 
/*     */     
/* 104 */     if (par1Slot == null && selectedTabIndex != CreativeTabs.field_78036_m.func_78021_a() && par4 != 5) {
/*     */       
/* 106 */       InventoryPlayer inventoryplayer = this.field_146297_k.field_71439_g.field_71071_by;
/*     */       
/* 108 */       if (inventoryplayer.func_70445_o() != null)
/*     */       {
/* 110 */         if (par3 == 0) {
/*     */           
/* 112 */           this.field_146297_k.field_71439_g.func_70099_a(inventoryplayer.func_70445_o(), 1.5F);
/* 113 */           this.field_146297_k.field_71442_b.func_78752_a(inventoryplayer.func_70445_o());
/* 114 */           inventoryplayer.func_70437_b((ItemStack)null);
/*     */         } 
/*     */         
/* 117 */         if (par3 == 1)
/*     */         {
/* 119 */           ItemStack itemstack = inventoryplayer.func_70445_o().func_77979_a(1);
/* 120 */           this.field_146297_k.field_71439_g.func_70099_a(itemstack, 1.5F);
/* 121 */           this.field_146297_k.field_71442_b.func_78752_a(itemstack);
/*     */           
/* 123 */           if ((inventoryplayer.func_70445_o()).field_77994_a == 0) {
/* 124 */             inventoryplayer.func_70437_b((ItemStack)null);
/*     */           
/*     */           }
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 132 */     else if (par1Slot == this.zeroSlot && flag) {
/*     */       
/* 134 */       for (int l = 0; l < this.field_146297_k.field_71439_g.field_71069_bz.func_75138_a().size(); l++)
/*     */       {
/* 136 */         this.field_146297_k.field_71442_b.func_78761_a((ItemStack)null, l);
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 143 */     else if (selectedTabIndex == CreativeTabs.field_78036_m.func_78021_a()) {
/*     */       
/* 145 */       if (par1Slot == this.zeroSlot)
/*     */       {
/* 147 */         this.field_146297_k.field_71439_g.field_71071_by.func_70437_b((ItemStack)null);
/*     */       }
/* 149 */       else if (par4 == 4 && par1Slot != null && par1Slot.func_75216_d())
/*     */       {
/* 151 */         ItemStack itemstack1 = par1Slot.func_75209_a((par3 == 0) ? 1 : par1Slot.func_75211_c().func_77976_d());
/* 152 */         this.field_146297_k.field_71439_g.func_70099_a(itemstack1, 1.5F);
/* 153 */         this.field_146297_k.field_71442_b.func_78752_a(itemstack1);
/*     */       }
/* 155 */       else if (par4 == 4 && this.field_146297_k.field_71439_g.field_71071_by.func_70445_o() != null)
/*     */       {
/* 157 */         this.field_146297_k.field_71439_g.func_70099_a(this.field_146297_k.field_71439_g.field_71071_by.func_70445_o(), 1.5F);
/* 158 */         this.field_146297_k.field_71442_b.func_78752_a(this.field_146297_k.field_71439_g.field_71071_by.func_70445_o());
/* 159 */         this.field_146297_k.field_71439_g.field_71071_by.func_70437_b((ItemStack)null);
/*     */       }
/*     */       else
/*     */       {
/* 163 */         this.field_146297_k.field_71439_g.field_71069_bz.func_75144_a((par1Slot == null) ? par2 : (SlotCreativeInventoryTFC.getSlot((SlotCreativeInventoryTFC)par1Slot)).field_75222_d, par3, par4, (EntityPlayer)this.field_146297_k.field_71439_g);
/* 164 */         this.field_146297_k.field_71439_g.field_71069_bz.func_75142_b();
/*     */       }
/*     */     
/* 167 */     } else if (par4 != 5 && par1Slot != null && par1Slot.field_75224_c == inventory) {
/*     */       
/* 169 */       InventoryPlayer inventoryplayer = this.field_146297_k.field_71439_g.field_71071_by;
/* 170 */       ItemStack itemstack = inventoryplayer.func_70445_o();
/* 171 */       ItemStack itemstack2 = par1Slot.func_75211_c();
/*     */ 
/*     */       
/* 174 */       if (par4 == 2) {
/*     */         
/* 176 */         if (itemstack2 != null && par3 >= 0 && par3 < 9) {
/*     */           
/* 178 */           ItemStack itemstack3 = itemstack2.func_77946_l();
/* 179 */           itemstack3.field_77994_a = itemstack3.func_77976_d();
/* 180 */           this.field_146297_k.field_71439_g.field_71071_by.func_70299_a(par3, itemstack3);
/* 181 */           this.field_146297_k.field_71439_g.field_71069_bz.func_75142_b();
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 187 */       if (par4 == 3) {
/*     */         
/* 189 */         if (inventoryplayer.func_70445_o() == null && par1Slot.func_75216_d()) {
/*     */           
/* 191 */           ItemStack itemstack3 = par1Slot.func_75211_c().func_77946_l();
/* 192 */           itemstack3.field_77994_a = itemstack3.func_77976_d();
/* 193 */           inventoryplayer.func_70437_b(itemstack3);
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 199 */       if (par4 == 4) {
/*     */         
/* 201 */         if (itemstack2 != null) {
/*     */           
/* 203 */           ItemStack itemstack3 = itemstack2.func_77946_l();
/* 204 */           itemstack3.field_77994_a = (par3 == 0) ? 1 : itemstack3.func_77976_d();
/* 205 */           this.field_146297_k.field_71439_g.func_70099_a(itemstack3, 1.5F);
/* 206 */           this.field_146297_k.field_71442_b.func_78752_a(itemstack3);
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 212 */       if (itemstack != null && itemstack2 != null && itemstack.func_77969_a(itemstack2) && ItemStack.func_77970_a(itemstack, itemstack2)) {
/*     */         
/* 214 */         if (par3 == 0) {
/*     */           
/* 216 */           if (flag) {
/* 217 */             itemstack.field_77994_a = itemstack.func_77976_d();
/* 218 */           } else if (itemstack.field_77994_a < itemstack.func_77976_d()) {
/* 219 */             itemstack.field_77994_a++;
/*     */           } 
/* 221 */         } else if (itemstack.field_77994_a <= 1) {
/*     */           
/* 223 */           inventoryplayer.func_70437_b((ItemStack)null);
/*     */         }
/*     */         else {
/*     */           
/* 227 */           itemstack.field_77994_a--;
/*     */         }
/*     */       
/* 230 */       } else if (itemstack2 != null && itemstack == null) {
/*     */         
/* 232 */         inventoryplayer.func_70437_b(ItemStack.func_77944_b(itemstack2));
/* 233 */         itemstack = inventoryplayer.func_70445_o();
/*     */         
/* 235 */         if (flag) {
/* 236 */           itemstack.field_77994_a = itemstack.func_77976_d();
/*     */         }
/*     */       } else {
/*     */         
/* 240 */         inventoryplayer.func_70437_b((ItemStack)null);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 245 */       this.field_147002_h.func_75144_a((par1Slot == null) ? par2 : par1Slot.field_75222_d, par3, par4, (EntityPlayer)this.field_146297_k.field_71439_g);
/*     */       
/* 247 */       if (Container.func_94532_c(par3) == 2) {
/*     */         
/* 249 */         for (int l = 0; l < 9; l++) {
/* 250 */           this.field_146297_k.field_71442_b.func_78761_a(this.field_147002_h.func_75139_a(45 + l).func_75211_c(), 36 + l);
/*     */         }
/* 252 */       } else if (par1Slot != null) {
/*     */         
/* 254 */         ItemStack itemstack1 = this.field_147002_h.func_75139_a(par1Slot.field_75222_d).func_75211_c();
/* 255 */         this.field_146297_k.field_71442_b.func_78761_a(itemstack1, par1Slot.field_75222_d - this.field_147002_h.field_75151_b.size() + 9 + 36);
/*     */       } 
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
/*     */   public void func_73866_w_() {
/* 268 */     if (this.field_146297_k.field_71442_b.func_78758_h()) {
/*     */       
/* 270 */       super.func_73866_w_();
/* 271 */       this.field_146292_n.clear();
/* 272 */       Keyboard.enableRepeatEvents(true);
/* 273 */       this.searchField = new GuiTextField(this.field_146289_q, this.field_147003_i + 82, this.field_147009_r + 6, 89, this.field_146289_q.field_78288_b);
/* 274 */       this.searchField.func_146203_f(15);
/* 275 */       this.searchField.func_146185_a(false);
/* 276 */       this.searchField.func_146189_e(false);
/* 277 */       this.searchField.func_146193_g(16777215);
/* 278 */       int i = selectedTabIndex;
/* 279 */       selectedTabIndex = -1;
/* 280 */       setCurrentCreativeTab(CreativeTabs.field_78032_a[i]);
/* 281 */       this.crafting = new CreativeCrafting(this.field_146297_k);
/* 282 */       this.field_146297_k.field_71439_g.field_71069_bz.func_75132_a((ICrafting)this.crafting);
/* 283 */       int tabCount = CreativeTabs.field_78032_a.length;
/* 284 */       if (tabCount > 12)
/*     */       {
/* 286 */         this.field_146292_n.add(new GuiButton(101, this.field_147003_i, this.field_147009_r - 50, 20, 20, "<"));
/* 287 */         this.field_146292_n.add(new GuiButton(102, this.field_147003_i + this.field_146999_f - 20, this.field_147009_r - 50, 20, 20, ">"));
/* 288 */         this.maxPages = (tabCount - 12) / 10 + 1;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 293 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiInventoryTFC((EntityPlayer)this.field_146297_k.field_71439_g));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/* 303 */     super.func_146281_b();
/*     */     
/* 305 */     if (this.field_146297_k.field_71439_g != null && this.field_146297_k.field_71439_g.field_71071_by != null) {
/* 306 */       this.field_146297_k.field_71439_g.field_71069_bz.func_82847_b((ICrafting)this.crafting);
/*     */     }
/* 308 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char par1, int par2) {
/* 317 */     if (!CreativeTabs.field_78032_a[selectedTabIndex].hasSearchBar()) {
/*     */       
/* 319 */       if (GameSettings.func_100015_a(this.field_146297_k.field_71474_y.field_74310_D)) {
/* 320 */         setCurrentCreativeTab(CreativeTabs.field_78027_g);
/*     */       } else {
/* 322 */         super.func_73869_a(par1, par2);
/*     */       } 
/*     */     } else {
/*     */       
/* 326 */       if (this.eventTriggered) {
/*     */         
/* 328 */         this.eventTriggered = false;
/* 329 */         this.searchField.func_146180_a("");
/*     */       } 
/*     */       
/* 332 */       if (!func_146983_a(par2))
/*     */       {
/* 334 */         if (this.searchField.func_146201_a(par1, par2)) {
/* 335 */           updateCreativeSearch();
/*     */         } else {
/* 337 */           super.func_73869_a(par1, par2);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void updateCreativeSearch() {
/* 344 */     ContainerCreativeTFC containercreative = (ContainerCreativeTFC)this.field_147002_h;
/* 345 */     containercreative.itemList.clear();
/*     */     
/* 347 */     CreativeTabs tab = CreativeTabs.field_78032_a[selectedTabIndex];
/* 348 */     if (tab.hasSearchBar() && tab != CreativeTabs.field_78027_g) {
/*     */       
/* 350 */       tab.func_78018_a(containercreative.itemList);
/* 351 */       updateFilteredItems(containercreative);
/*     */       
/*     */       return;
/*     */     } 
/* 355 */     Iterator<Item> iItems = Item.field_150901_e.iterator();
/* 356 */     while (iItems.hasNext()) {
/*     */       
/* 358 */       Item item = iItems.next();
/* 359 */       if (item != null && item.func_77640_w() != null) {
/* 360 */         item.func_150895_a(item, (CreativeTabs)null, containercreative.itemList);
/*     */       }
/*     */     } 
/* 363 */     Enchantment[] aenchantment = Enchantment.field_77331_b;
/* 364 */     int i = aenchantment.length;
/* 365 */     for (int j = 0; j < i; j++) {
/*     */       
/* 367 */       Enchantment enchantment = aenchantment[j];
/* 368 */       if (enchantment != null && enchantment.field_77351_y != null)
/* 369 */         Items.field_151134_bR.func_92113_a(enchantment, containercreative.itemList); 
/*     */     } 
/* 371 */     updateFilteredItems(containercreative);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateFilteredItems(ContainerCreativeTFC containercreative) {
/* 377 */     Iterator<ItemStack> iterator = containercreative.itemList.iterator();
/* 378 */     String s = this.searchField.func_146179_b().toLowerCase();
/*     */     
/* 380 */     while (iterator.hasNext()) {
/*     */       
/* 382 */       ItemStack itemstack = iterator.next();
/* 383 */       boolean flag = false;
/* 384 */       Iterator<String> iterator1 = itemstack.func_82840_a((EntityPlayer)this.field_146297_k.field_71439_g, this.field_146297_k.field_71474_y.field_82882_x).iterator();
/* 385 */       boolean loop = true;
/*     */       
/* 387 */       while (loop) {
/*     */         
/* 389 */         if (iterator1.hasNext()) {
/*     */           
/* 391 */           String s1 = iterator1.next();
/* 392 */           if (!s1.toLowerCase().contains(s))
/*     */             continue; 
/* 394 */           flag = true;
/*     */         } 
/*     */         
/* 397 */         if (!flag)
/* 398 */           iterator.remove(); 
/* 399 */         loop = false;
/*     */       } 
/*     */     } 
/*     */     
/* 403 */     this.currentScroll = 0.0F;
/* 404 */     containercreative.scrollTo(0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146979_b(int par1, int par2) {
/* 413 */     CreativeTabs creativetabs = CreativeTabs.field_78032_a[selectedTabIndex];
/* 414 */     if (creativetabs != null && creativetabs.func_78019_g()) {
/* 415 */       this.field_146289_q.func_78276_b(I18n.func_135052_a(creativetabs.func_78024_c(), new Object[0]), 8, 6, 4210752);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int par1, int par2, int par3) {
/* 424 */     if (par3 == 0) {
/*     */       
/* 426 */       int l = par1 - this.field_147003_i;
/* 427 */       int i1 = par2 - this.field_147009_r;
/* 428 */       CreativeTabs[] acreativetabs = CreativeTabs.field_78032_a;
/* 429 */       int j1 = acreativetabs.length;
/*     */       
/* 431 */       for (int k1 = 0; k1 < j1; k1++) {
/*     */         
/* 433 */         CreativeTabs creativetabs = acreativetabs[k1];
/* 434 */         if (switchTab(creativetabs, l, i1))
/*     */           return; 
/*     */       } 
/*     */     } 
/* 438 */     super.func_73864_a(par1, par2, par3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146286_b(int par1, int par2, int par3) {
/* 448 */     if (par3 == 0) {
/*     */       
/* 450 */       int l = par1 - this.field_147003_i;
/* 451 */       int i1 = par2 - this.field_147009_r;
/* 452 */       CreativeTabs[] acreativetabs = CreativeTabs.field_78032_a;
/* 453 */       int j1 = acreativetabs.length;
/*     */       
/* 455 */       for (int k1 = 0; k1 < j1; k1++) {
/*     */         
/* 457 */         CreativeTabs creativetabs = acreativetabs[k1];
/* 458 */         if (creativetabs != null && switchTab(creativetabs, l, i1)) {
/*     */           
/* 460 */           setCurrentCreativeTab(creativetabs);
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 466 */     super.func_146286_b(par1, par2, par3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean needsScrollBars() {
/* 474 */     if (CreativeTabs.field_78032_a[selectedTabIndex] == null) return false; 
/* 475 */     return (selectedTabIndex != CreativeTabs.field_78036_m.func_78021_a() && CreativeTabs.field_78032_a[selectedTabIndex].func_78017_i() && ((ContainerCreativeTFC)this.field_147002_h).hasMoreThan1PageOfItemsInList());
/*     */   }
/*     */ 
/*     */   
/*     */   private void setCurrentCreativeTab(CreativeTabs par1CreativeTabs) {
/* 480 */     if (par1CreativeTabs == null) {
/*     */       return;
/*     */     }
/* 483 */     int i = selectedTabIndex;
/* 484 */     selectedTabIndex = par1CreativeTabs.func_78021_a();
/* 485 */     ContainerCreativeTFC containercreative = (ContainerCreativeTFC)this.field_147002_h;
/* 486 */     this.field_147008_s.clear();
/* 487 */     containercreative.itemList.clear();
/* 488 */     par1CreativeTabs.func_78018_a(containercreative.itemList);
/*     */     
/* 490 */     if (par1CreativeTabs == CreativeTabs.field_78036_m) {
/*     */       
/* 492 */       Container container = this.field_146297_k.field_71439_g.field_71069_bz;
/* 493 */       if (this.backupContainerSlots == null) {
/* 494 */         this.backupContainerSlots = containercreative.field_75151_b;
/*     */       }
/* 496 */       containercreative.field_75151_b = new ArrayList();
/* 497 */       for (int j = 0; j < container.field_75151_b.size(); j++) {
/*     */         
/* 499 */         SlotCreativeInventoryTFC slotcreativeinventory = new SlotCreativeInventoryTFC(this, container.field_75151_b.get(j), j);
/* 500 */         containercreative.field_75151_b.add(slotcreativeinventory);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 505 */         if (j >= 5 && j < 9) {
/*     */           
/* 507 */           int k = j - 5;
/* 508 */           int l = k / 2;
/* 509 */           int i1 = k % 2;
/* 510 */           slotcreativeinventory.field_75223_e = 9 + l * 54;
/* 511 */           slotcreativeinventory.field_75221_f = 6 + i1 * 27;
/*     */         }
/* 513 */         else if (j == 50) {
/*     */           
/* 515 */           int k = 2;
/* 516 */           int l = k / 2;
/* 517 */           int i1 = k % 2;
/* 518 */           slotcreativeinventory.field_75223_e = 27 + l * 54;
/* 519 */           slotcreativeinventory.field_75221_f = 6 + i1 * 27;
/*     */         }
/* 521 */         else if (j >= 0 && j < 5) {
/*     */           
/* 523 */           slotcreativeinventory.field_75221_f = -2000;
/* 524 */           slotcreativeinventory.field_75223_e = -2000;
/*     */         }
/* 526 */         else if (j < container.field_75151_b.size()) {
/*     */           
/* 528 */           int k = j - 9;
/* 529 */           int l = k % 9;
/* 530 */           int i1 = k / 9;
/* 531 */           slotcreativeinventory.field_75223_e = 9 + l * 18;
/*     */           
/* 533 */           if (j >= 36) {
/* 534 */             slotcreativeinventory.field_75221_f = 112;
/*     */           } else {
/* 536 */             slotcreativeinventory.field_75221_f = 54 + i1 * 18;
/*     */           } 
/*     */         } 
/*     */       } 
/* 540 */       this.zeroSlot = new Slot((IInventory)inventory, 0, 173, 112);
/* 541 */       containercreative.field_75151_b.add(this.zeroSlot);
/*     */     }
/* 543 */     else if (i == CreativeTabs.field_78036_m.func_78021_a()) {
/*     */       
/* 545 */       containercreative.field_75151_b = this.backupContainerSlots;
/* 546 */       this.backupContainerSlots = null;
/*     */     } 
/*     */     
/* 549 */     if (this.searchField != null)
/*     */     {
/* 551 */       if (par1CreativeTabs.hasSearchBar()) {
/*     */         
/* 553 */         this.searchField.func_146189_e(true);
/* 554 */         this.searchField.func_146205_d(false);
/* 555 */         this.searchField.func_146195_b(true);
/* 556 */         this.searchField.func_146180_a("");
/* 557 */         updateCreativeSearch();
/*     */       }
/*     */       else {
/*     */         
/* 561 */         this.searchField.func_146189_e(false);
/* 562 */         this.searchField.func_146205_d(true);
/* 563 */         this.searchField.func_146195_b(false);
/*     */       } 
/*     */     }
/*     */     
/* 567 */     this.currentScroll = 0.0F;
/* 568 */     containercreative.scrollTo(0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146274_d() {
/* 577 */     super.func_146274_d();
/* 578 */     int i = Mouse.getEventDWheel();
/*     */     
/* 580 */     if (i != 0 && needsScrollBars()) {
/*     */       
/* 582 */       int j = ((ContainerCreativeTFC)this.field_147002_h).itemList.size() / 9 - 5 + 1;
/*     */       
/* 584 */       if (i > 0)
/* 585 */         i = 1; 
/* 586 */       if (i < 0) {
/* 587 */         i = -1;
/*     */       }
/* 589 */       this.currentScroll = (float)(this.currentScroll - i / j);
/*     */       
/* 591 */       if (this.currentScroll < 0.0F) {
/* 592 */         this.currentScroll = 0.0F;
/*     */       }
/* 594 */       if (this.currentScroll > 1.0F) {
/* 595 */         this.currentScroll = 1.0F;
/*     */       }
/* 597 */       ((ContainerCreativeTFC)this.field_147002_h).scrollTo(this.currentScroll);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int par1, int par2, float par3) {
/* 607 */     boolean flag = Mouse.isButtonDown(0);
/* 608 */     int k = this.field_147003_i;
/* 609 */     int l = this.field_147009_r;
/* 610 */     int i1 = k + 175;
/* 611 */     int j1 = l + 18;
/* 612 */     int k1 = i1 + 14;
/* 613 */     int l1 = j1 + 112;
/*     */     
/* 615 */     if (!this.wasClicking && flag && par1 >= i1 && par2 >= j1 && par1 < k1 && par2 < l1) {
/* 616 */       this.isScrolling = needsScrollBars();
/*     */     }
/* 618 */     if (!flag) {
/* 619 */       this.isScrolling = false;
/*     */     }
/* 621 */     this.wasClicking = flag;
/*     */     
/* 623 */     if (this.isScrolling) {
/*     */       
/* 625 */       this.currentScroll = ((par2 - j1) - 7.5F) / ((l1 - j1) - 15.0F);
/*     */       
/* 627 */       if (this.currentScroll < 0.0F) {
/* 628 */         this.currentScroll = 0.0F;
/*     */       }
/* 630 */       if (this.currentScroll > 1.0F) {
/* 631 */         this.currentScroll = 1.0F;
/*     */       }
/* 633 */       ((ContainerCreativeTFC)this.field_147002_h).scrollTo(this.currentScroll);
/*     */     } 
/*     */     
/* 636 */     super.func_73863_a(par1, par2, par3);
/* 637 */     CreativeTabs[] acreativetabs = CreativeTabs.field_78032_a;
/* 638 */     int start = tabPage * 10;
/* 639 */     int i2 = Math.min(acreativetabs.length, (tabPage + 1) * 10 + 2);
/* 640 */     if (tabPage != 0) start += 2; 
/* 641 */     boolean rendered = false;
/*     */     
/* 643 */     for (int j2 = start; j2 < i2; j2++) {
/*     */       
/* 645 */       CreativeTabs creativetabs = acreativetabs[j2];
/*     */       
/* 647 */       if (creativetabs != null && renderCreativeInventoryHoveringText(creativetabs, par1, par2)) {
/*     */         
/* 649 */         rendered = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 654 */     if (!rendered && !renderCreativeInventoryHoveringText(CreativeTabs.field_78027_g, par1, par2)) {
/* 655 */       renderCreativeInventoryHoveringText(CreativeTabs.field_78036_m, par1, par2);
/*     */     }
/* 657 */     if (this.zeroSlot != null && selectedTabIndex == CreativeTabs.field_78036_m.func_78021_a() && 
/* 658 */       func_146978_c(this.zeroSlot.field_75223_e, this.zeroSlot.field_75221_f, 16, 16, par1, par2))
/*     */     {
/* 660 */       func_146279_a(I18n.func_135052_a("inventory.binSlot", new Object[0]), par1, par2);
/*     */     }
/*     */     
/* 663 */     if (this.maxPages != 0) {
/*     */       
/* 665 */       String page = String.format("%d / %d", new Object[] { Integer.valueOf(tabPage + 1), Integer.valueOf(this.maxPages + 1) });
/* 666 */       int width = this.field_146289_q.func_78256_a(page);
/* 667 */       GL11.glDisable(2896);
/* 668 */       this.field_73735_i = 300.0F;
/* 669 */       field_146296_j.field_77023_b = 300.0F;
/* 670 */       this.field_146289_q.func_78276_b(page, this.field_147003_i + this.field_146999_f / 2 - width / 2, this.field_147009_r - 44, -1);
/* 671 */       this.field_73735_i = 0.0F;
/* 672 */       field_146296_j.field_77023_b = 0.0F;
/*     */     } 
/*     */     
/* 675 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 676 */     GL11.glDisable(2896);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146285_a(ItemStack par1ItemStack, int par2, int par3) {
/* 682 */     if (selectedTabIndex == CreativeTabs.field_78027_g.func_78021_a()) {
/*     */       
/* 684 */       List<String> list = par1ItemStack.func_82840_a((EntityPlayer)this.field_146297_k.field_71439_g, this.field_146297_k.field_71474_y.field_82882_x);
/* 685 */       CreativeTabs creativetabs = par1ItemStack.func_77973_b().func_77640_w();
/*     */       
/* 687 */       if (creativetabs == null && par1ItemStack.func_77973_b() == Items.field_151134_bR) {
/*     */         
/* 689 */         Map map = EnchantmentHelper.func_82781_a(par1ItemStack);
/*     */         
/* 691 */         if (map.size() == 1) {
/*     */           
/* 693 */           Enchantment enchantment = Enchantment.field_77331_b[((Integer)map.keySet().iterator().next()).intValue()];
/* 694 */           CreativeTabs[] acreativetabs = CreativeTabs.field_78032_a;
/* 695 */           int k = acreativetabs.length;
/*     */           
/* 697 */           for (int l = 0; l < k; l++) {
/*     */             
/* 699 */             CreativeTabs creativetabs1 = acreativetabs[l];
/* 700 */             if (creativetabs1.func_111226_a(enchantment.field_77351_y)) {
/*     */               
/* 702 */               creativetabs = creativetabs1;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 709 */       if (creativetabs != null) {
/* 710 */         list.add(1, EnumChatFormatting.BOLD.toString() + EnumChatFormatting.BLUE + I18n.func_135052_a(creativetabs.func_78024_c(), new Object[0]));
/*     */       }
/* 712 */       for (int i1 = 0; i1 < list.size(); i1++) {
/*     */         
/* 714 */         if (i1 == 0) {
/* 715 */           list.set(i1, (par1ItemStack.func_77953_t()).field_77937_e + (String)list.get(i1));
/*     */         } else {
/* 717 */           list.set(i1, EnumChatFormatting.GRAY + (String)list.get(i1));
/*     */         } 
/*     */       } 
/* 720 */       func_146283_a(list, par2, par3);
/*     */     }
/*     */     else {
/*     */       
/* 724 */       super.func_146285_a(par1ItemStack, par2, par3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float par1, int par2, int par3) {
/* 734 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 735 */     RenderHelper.func_74520_c();
/* 736 */     CreativeTabs creativetabs = CreativeTabs.field_78032_a[selectedTabIndex];
/* 737 */     CreativeTabs[] acreativetabs = CreativeTabs.field_78032_a;
/* 738 */     int k = acreativetabs.length;
/*     */ 
/*     */     
/* 741 */     int start = tabPage * 10;
/* 742 */     k = Math.min(acreativetabs.length, (tabPage + 1) * 10 + 2);
/* 743 */     if (tabPage != 0) start += 2; 
/* 744 */     GL11.glEnable(3008); int l;
/* 745 */     for (l = start; l < k; l++) {
/*     */       
/* 747 */       CreativeTabs creativetabs1 = acreativetabs[l];
/* 748 */       this.field_146297_k.func_110434_K().func_110577_a(TEXTURE);
/* 749 */       if (creativetabs1 != null && creativetabs1.func_78021_a() != selectedTabIndex) {
/* 750 */         renderCreativeTab(creativetabs1);
/*     */       }
/*     */     } 
/* 753 */     if (tabPage != 0) {
/*     */       
/* 755 */       if (creativetabs != CreativeTabs.field_78027_g) {
/*     */         
/* 757 */         this.field_146297_k.func_110434_K().func_110577_a(TEXTURE);
/* 758 */         renderCreativeTab(CreativeTabs.field_78027_g);
/*     */       } 
/* 760 */       if (creativetabs != CreativeTabs.field_78036_m) {
/*     */         
/* 762 */         this.field_146297_k.func_110434_K().func_110577_a(TEXTURE);
/* 763 */         renderCreativeTab(CreativeTabs.field_78036_m);
/*     */       } 
/*     */     } 
/* 766 */     this.field_146297_k.func_110434_K().func_110577_a(new ResourceLocation("textures/gui/container/creative_inventory/tab_" + creativetabs.func_78015_f()));
/* 767 */     func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
/* 768 */     this.searchField.func_146194_f();
/* 769 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 770 */     int i1 = this.field_147003_i + 175;
/* 771 */     k = this.field_147009_r + 18;
/* 772 */     l = k + 112;
/* 773 */     this.field_146297_k.func_110434_K().func_110577_a(TEXTURE);
/*     */     
/* 775 */     if (creativetabs.func_78017_i()) {
/* 776 */       func_73729_b(i1, k + (int)((l - k - 17) * this.currentScroll), 232 + (needsScrollBars() ? 0 : 12), 0, 12, 15);
/*     */     }
/* 778 */     if (creativetabs.getTabPage() != tabPage && 
/* 779 */       creativetabs != CreativeTabs.field_78027_g && creativetabs != CreativeTabs.field_78036_m) {
/*     */       return;
/*     */     }
/* 782 */     renderCreativeTab(creativetabs);
/*     */     
/* 784 */     if (creativetabs == CreativeTabs.field_78036_m)
/* 785 */       GuiInventoryTFC.drawPlayerModel(this.field_147003_i + 43, this.field_147009_r + 45, 20, (this.field_147003_i + 43 - par2), (this.field_147009_r + 45 - 30 - par3), (EntityLivingBase)this.field_146297_k.field_71439_g); 
/*     */   }
/*     */   
/*     */   protected boolean switchTab(CreativeTabs par1CreativeTabs, int par2, int par3) {
/*     */     int i1;
/* 790 */     if (par1CreativeTabs.getTabPage() != tabPage && 
/* 791 */       par1CreativeTabs != CreativeTabs.field_78027_g && par1CreativeTabs != CreativeTabs.field_78036_m) {
/* 792 */       return false;
/*     */     }
/* 794 */     int k = par1CreativeTabs.func_78020_k();
/* 795 */     int l = 28 * k;
/* 796 */     byte b0 = 0;
/*     */     
/* 798 */     if (k == 5) {
/* 799 */       l = this.field_146999_f - 28 + 2;
/* 800 */     } else if (k > 0) {
/* 801 */       l += k;
/*     */     } 
/*     */ 
/*     */     
/* 805 */     if (par1CreativeTabs.func_78023_l()) {
/* 806 */       i1 = b0 - 32;
/*     */     } else {
/* 808 */       i1 = b0 + this.field_147000_g;
/*     */     } 
/* 810 */     return (par2 >= l && par2 <= l + 28 && par3 >= i1 && par3 <= i1 + 32);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderCreativeInventoryHoveringText(CreativeTabs par1CreativeTabs, int par2, int par3) {
/* 819 */     int i1, k = par1CreativeTabs.func_78020_k();
/* 820 */     int l = 28 * k;
/* 821 */     byte b0 = 0;
/*     */     
/* 823 */     if (k == 5) {
/* 824 */       l = this.field_146999_f - 28 + 2;
/* 825 */     } else if (k > 0) {
/* 826 */       l += k;
/*     */     } 
/*     */ 
/*     */     
/* 830 */     if (par1CreativeTabs.func_78023_l()) {
/* 831 */       i1 = b0 - 32;
/*     */     } else {
/* 833 */       i1 = b0 + this.field_147000_g;
/*     */     } 
/* 835 */     if (func_146978_c(l + 3, i1 + 3, 23, 27, par2, par3)) {
/*     */       
/* 837 */       func_146279_a(I18n.func_135052_a(par1CreativeTabs.func_78024_c(), new Object[0]), par2, par3);
/* 838 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 842 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderCreativeTab(CreativeTabs par1CreativeTabs) {
/* 851 */     boolean flag = (par1CreativeTabs.func_78021_a() == selectedTabIndex);
/* 852 */     boolean flag1 = par1CreativeTabs.func_78023_l();
/* 853 */     int i = par1CreativeTabs.func_78020_k();
/* 854 */     int j = i * 28;
/* 855 */     int k = 0;
/* 856 */     int l = this.field_147003_i + 28 * i;
/* 857 */     int i1 = this.field_147009_r;
/* 858 */     byte b0 = 32;
/*     */     
/* 860 */     if (flag) {
/* 861 */       k += 32;
/*     */     }
/* 863 */     if (i == 5) {
/* 864 */       l = this.field_147003_i + this.field_146999_f - 28;
/* 865 */     } else if (i > 0) {
/* 866 */       l += i;
/*     */     } 
/* 868 */     if (flag1) {
/*     */       
/* 870 */       i1 -= 28;
/*     */     }
/*     */     else {
/*     */       
/* 874 */       k += 64;
/* 875 */       i1 += this.field_147000_g - 4;
/*     */     } 
/*     */     
/* 878 */     GL11.glDisable(2896);
/* 879 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 880 */     GL11.glEnable(3008);
/* 881 */     func_73729_b(l, i1, j, k, 28, b0);
/* 882 */     this.field_73735_i = 100.0F;
/* 883 */     field_146296_j.field_77023_b = 100.0F;
/* 884 */     l += 6;
/* 885 */     i1 += 8 + (flag1 ? 1 : -1);
/* 886 */     GL11.glEnable(2896);
/* 887 */     GL11.glEnable(32826);
/* 888 */     ItemStack itemstack = par1CreativeTabs.func_151244_d();
/* 889 */     if (itemstack != null) {
/*     */       
/* 891 */       field_146296_j.func_82406_b(this.field_146289_q, this.field_146297_k.func_110434_K(), itemstack, l, i1);
/* 892 */       field_146296_j.func_77021_b(this.field_146289_q, this.field_146297_k.func_110434_K(), itemstack, l, i1);
/*     */     } 
/* 894 */     GL11.glDisable(2896);
/* 895 */     field_146296_j.field_77023_b = 0.0F;
/* 896 */     this.field_73735_i = 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton par1GuiButton) {
/* 905 */     if (par1GuiButton.field_146127_k == 0) {
/* 906 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiAchievements((GuiScreen)this, this.field_146297_k.field_71439_g.func_146107_m()));
/*     */     }
/* 908 */     if (par1GuiButton.field_146127_k == 1) {
/* 909 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiStats((GuiScreen)this, this.field_146297_k.field_71439_g.func_146107_m()));
/*     */     }
/* 911 */     if (par1GuiButton.field_146127_k == 101) {
/* 912 */       tabPage = Math.max(tabPage - 1, 0);
/* 913 */     } else if (par1GuiButton.field_146127_k == 102) {
/* 914 */       tabPage = Math.min(tabPage + 1, this.maxPages);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentTabIndex() {
/* 922 */     return selectedTabIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static InventoryBasic getInventory() {
/* 930 */     return inventory;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiContainerCreativeTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */