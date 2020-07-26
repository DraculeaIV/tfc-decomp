/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.Core.TFC_Achievements;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilRecipe;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilReq;
/*     */ import com.bioxx.tfc.api.Enums.RuleEnum;
/*     */ import com.bioxx.tfc.api.Events.AnvilCraftEvent;
/*     */ import com.bioxx.tfc.api.HeatIndex;
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraftforge.common.MinecraftForge;
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
/*     */ public class TEAnvil
/*     */   extends NetworkTileEntity
/*     */   implements IInventory
/*     */ {
/*     */   public ItemStack[] anvilItemStacks;
/*     */   public int itemCraftingValue;
/*     */   public int[] itemCraftingRules;
/*     */   public int craftingValue;
/*     */   public int craftingRange;
/*     */   public int craftingReq;
/*     */   public String craftingPlan;
/*     */   public int[] stonePair;
/*     */   private byte workedRecently;
/*     */   private static final byte LAG_FIX_DELAY = 5;
/*     */   public AnvilRecipe workRecipe;
/*  62 */   public int anvilTier = AnvilReq.STONE.Tier;
/*     */   
/*     */   public EntityPlayer lastWorker;
/*     */   
/*     */   public static final int INPUT1_SLOT = 1;
/*     */   
/*     */   public static final int WELD1_SLOT = 2;
/*     */   
/*     */   public static final int WELD2_SLOT = 3;
/*     */   public static final int WELDOUT_SLOT = 4;
/*     */   public static final int INPUT2_SLOT = 5;
/*     */   public static final int FLUX_SLOT = 6;
/*     */   public static final int HAMMER_SLOT = 0;
/*     */   public static final String ITEM_CRAFTING_VALUE_TAG = "itemCraftingValue";
/*     */   public static final String ITEM_CRAFTING_RULE_1_TAG = "itemCraftingRule1";
/*     */   public static final String ITEM_CRAFTING_RULE_2_TAG = "itemCraftingRule2";
/*     */   public static final String ITEM_CRAFTING_RULE_3_TAG = "itemCraftingRule3";
/*     */   
/*     */   public TEAnvil() {
/*  81 */     this.anvilItemStacks = new ItemStack[19];
/*  82 */     this.itemCraftingValue = 0;
/*  83 */     this.itemCraftingRules = new int[] { -1, -1, -1 };
/*  84 */     this.craftingValue = 0;
/*  85 */     this.anvilTier = AnvilReq.STONE.Tier;
/*  86 */     this.stonePair = new int[] { 0, 0 };
/*  87 */     this.craftingPlan = "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/*  93 */     if (this.anvilItemStacks[1] == null) {
/*     */       
/*  95 */       this.workRecipe = null;
/*  96 */       this.craftingValue = 0;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     if (!this.field_145850_b.field_72995_K) {
/*     */ 
/*     */       
/* 105 */       if (getItemCraftingValue() > 150) {
/* 106 */         func_70299_a(1, (ItemStack)null);
/*     */       }
/* 108 */       if (this.workedRecently > 0) {
/* 109 */         this.workedRecently = (byte)(this.workedRecently - 1);
/*     */       }
/* 111 */       TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */ 
/*     */ 
/*     */       
/* 115 */       if (this.workRecipe != null && getItemCraftingValue() != this.itemCraftingValue) {
/*     */         
/* 117 */         this.itemCraftingValue = getItemCraftingValue();
/* 118 */         AnvilManager manager = AnvilManager.getInstance();
/* 119 */         Object[] r = getRecipe(manager);
/* 120 */         AnvilRecipe recipe = (r != null && r[0] != null) ? (AnvilRecipe)r[0] : null;
/* 121 */         ItemStack result = (r != null && r[1] != null) ? (ItemStack)r[1] : null;
/*     */ 
/*     */         
/* 124 */         if (result != null) {
/*     */           
/* 126 */           AnvilCraftEvent eventCraft = new AnvilCraftEvent(this.lastWorker, this, this.anvilItemStacks[1], this.anvilItemStacks[5], result);
/* 127 */           MinecraftForge.EVENT_BUS.post((Event)eventCraft);
/* 128 */           if (!eventCraft.isCanceled()) {
/*     */ 
/*     */             
/* 131 */             TFC_ItemHeat.setTemp(eventCraft.result, TFC_ItemHeat.getTemp(this.anvilItemStacks[1]));
/*     */             
/* 133 */             ItemStack output = eventCraft.result;
/*     */             
/* 135 */             if (output != null && this.lastWorker != null && recipe != null) {
/*     */               
/* 137 */               if (output.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemMiscToolHead) {
/*     */                 
/* 139 */                 AnvilManager.setDurabilityBuff(output, recipe.getSkillMult(this.lastWorker));
/* 140 */                 AnvilManager.setDamageBuff(output, recipe.getSkillMult(this.lastWorker));
/*     */               }
/* 142 */               else if (output.func_77973_b() instanceof com.bioxx.tfc.Items.ItemTFCArmor) {
/*     */                 
/* 144 */                 AnvilManager.setDurabilityBuff(output, recipe.getSkillMult(this.lastWorker));
/*     */               } 
/*     */               
/* 147 */               if (output.func_77973_b() instanceof com.bioxx.tfc.Items.ItemIngot) {
/*     */                 
/* 149 */                 Item ingot = output.func_77973_b();
/* 150 */                 if (ingot == TFCItems.blackSteelIngot) {
/* 151 */                   this.lastWorker.func_71029_a((StatBase)TFC_Achievements.achBlackSteel);
/* 152 */                 } else if (ingot == TFCItems.blueSteelIngot) {
/* 153 */                   this.lastWorker.func_71029_a((StatBase)TFC_Achievements.achBlueSteel);
/* 154 */                 } else if (ingot == TFCItems.redSteelIngot) {
/* 155 */                   this.lastWorker.func_71029_a((StatBase)TFC_Achievements.achRedSteel);
/*     */                 } 
/* 157 */               } else if (output.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemSteelBucket) {
/*     */                 
/* 159 */                 Item bucket = output.func_77973_b();
/* 160 */                 if (bucket == TFCItems.blueSteelBucketEmpty) {
/* 161 */                   this.lastWorker.func_71029_a((StatBase)TFC_Achievements.achBlueBucket);
/* 162 */                 } else if (bucket == TFCItems.redSteelBucketEmpty) {
/* 163 */                   this.lastWorker.func_71029_a((StatBase)TFC_Achievements.achRedBucket);
/*     */                 } 
/*     */               } 
/* 166 */               increaseSkills(recipe);
/* 167 */               removeRules(1);
/*     */             } 
/*     */             
/* 170 */             func_70299_a(1, output);
/*     */             
/* 172 */             if (this.anvilItemStacks[5] != null) {
/* 173 */               (this.anvilItemStacks[5]).field_77994_a--;
/*     */             }
/*     */           } 
/* 176 */           this.workRecipe = null;
/* 177 */           this.craftingPlan = "";
/* 178 */           this.craftingValue = 0;
/* 179 */           this.lastWorker = null;
/*     */         } 
/*     */       } 
/*     */     } 
/* 183 */     if (this.anvilItemStacks[1] != null && (this.anvilItemStacks[1]).field_77994_a < 1) {
/* 184 */       (this.anvilItemStacks[1]).field_77994_a = 1;
/*     */     }
/*     */   }
/*     */   
/*     */   public void increaseSkills(AnvilRecipe recipe) {
/* 189 */     if (this.lastWorker != null)
/*     */     {
/* 191 */       for (String s : recipe.skillsList)
/*     */       {
/* 193 */         TFC_Core.getSkillStats(this.lastWorker).increaseSkill(s, recipe.craftingXP);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] getRecipe(AnvilManager manager) {
/* 203 */     Object[] out = new Object[2];
/*     */     
/* 205 */     if (this.itemCraftingValue == this.workRecipe.getCraftingValue())
/*     */     {
/* 207 */       out = manager.findCompleteRecipe(new AnvilRecipe(this.anvilItemStacks[1], this.anvilItemStacks[5], this.craftingPlan, this.workRecipe
/* 208 */             .getCraftingValue(), (this.anvilItemStacks[6] != null), this.anvilTier, null), 
/* 209 */           getItemRules());
/*     */     }
/* 211 */     return out;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onSlotChanged(int slot) {
/* 219 */     if (slot == 1 || slot == 5 || slot == 6) {
/* 220 */       updateRecipe();
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateRecipe() {
/* 225 */     AnvilManager manager = AnvilManager.getInstance();
/* 226 */     Object[] plans = manager.getPlans().keySet().toArray();
/* 227 */     Map<String, AnvilRecipe> planList = new HashMap<String, AnvilRecipe>();
/*     */     
/* 229 */     for (Object p : plans) {
/*     */       
/* 231 */       AnvilRecipe ar = manager.findMatchingRecipe(new AnvilRecipe(this.anvilItemStacks[1], this.anvilItemStacks[5], (String)p, (this.anvilItemStacks[6] != null), this.anvilTier));
/*     */ 
/*     */       
/* 234 */       if (ar != null) {
/* 235 */         planList.put((String)p, ar);
/*     */       }
/*     */     } 
/*     */     
/* 239 */     if (this.anvilItemStacks[1] != null && this.anvilItemStacks[1].func_77973_b() == TFCItems.bloom)
/*     */     {
/* 241 */       if (this.anvilItemStacks[1].func_77960_j() <= 100 && planList.containsKey("splitbloom")) {
/* 242 */         planList.remove("splitbloom");
/*     */       }
/*     */     }
/*     */     
/* 246 */     if (planList.isEmpty()) {
/*     */       
/* 248 */       this.workRecipe = null;
/* 249 */       this.craftingPlan = "";
/* 250 */       this.lastWorker = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 264 */     if (planList.containsKey(this.craftingPlan)) {
/* 265 */       this.workRecipe = planList.get(this.craftingPlan);
/*     */     } else {
/*     */       
/* 268 */       this.workRecipe = null;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 273 */     if (this.anvilItemStacks[1] != null && this.anvilItemStacks[1].func_77973_b() == TFCItems.bloom && this.workRecipe.getCraftingResult().func_77973_b() == TFCItems.bloom)
/*     */     {
/* 275 */       if (this.anvilItemStacks[1].func_77960_j() < 100) {
/*     */         
/* 277 */         this.craftingPlan = "";
/* 278 */         this.workRecipe = null;
/*     */       }
/* 280 */       else if (this.anvilItemStacks[1].func_77960_j() == 100) {
/*     */         
/* 282 */         this.craftingPlan = "refinebloom";
/* 283 */         this.workRecipe = planList.get(this.craftingPlan);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/* 292 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCraftingValue() {
/* 302 */     return (this.workRecipe != null) ? this.workRecipe.getCraftingValue() : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRules(int rule, int slot) {
/* 307 */     if (this.anvilItemStacks[slot].func_77942_o()) {
/*     */       
/* 309 */       NBTTagCompound tag = this.anvilItemStacks[slot].func_77978_p();
/* 310 */       int rule1 = -1;
/* 311 */       int rule2 = -1;
/* 312 */       if (tag.func_74764_b("itemCraftingRule1"))
/*     */       {
/* 314 */         rule1 = tag.func_74771_c("itemCraftingRule1");
/*     */       }
/* 316 */       if (tag.func_74764_b("itemCraftingRule2"))
/*     */       {
/* 318 */         rule2 = tag.func_74771_c("itemCraftingRule2");
/*     */       }
/* 320 */       if (tag.func_74764_b("itemCraftingRule3"))
/*     */       {
/* 322 */         tag.func_74771_c("itemCraftingRule3");
/*     */       }
/*     */       
/* 325 */       this.itemCraftingRules[2] = rule2;
/* 326 */       this.itemCraftingRules[1] = rule1;
/* 327 */       this.itemCraftingRules[0] = rule;
/*     */       
/* 329 */       tag.func_74774_a("itemCraftingRule1", (byte)this.itemCraftingRules[0]);
/* 330 */       tag.func_74774_a("itemCraftingRule2", (byte)this.itemCraftingRules[1]);
/* 331 */       tag.func_74774_a("itemCraftingRule3", (byte)this.itemCraftingRules[2]);
/*     */       
/* 333 */       this.anvilItemStacks[slot].func_77982_d(tag);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRules(int slot) {
/* 339 */     if (this.anvilItemStacks[slot].func_77942_o()) {
/*     */       
/* 341 */       NBTTagCompound tag = this.anvilItemStacks[slot].func_77978_p();
/*     */ 
/*     */       
/* 344 */       tag.func_82580_o("itemCraftingRule1");
/* 345 */       tag.func_82580_o("itemCraftingRule2");
/* 346 */       tag.func_82580_o("itemCraftingRule3");
/* 347 */       tag.func_82580_o("itemCraftingValue");
/*     */       
/* 349 */       this.anvilItemStacks[slot].func_77982_d(tag);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] getItemRules() {
/* 355 */     int[] rules = new int[3];
/* 356 */     ItemStack input = this.anvilItemStacks[1];
/*     */     
/* 358 */     if (input != null && input.func_77942_o()) {
/*     */       
/* 360 */       NBTTagCompound tag = input.func_77978_p();
/* 361 */       if (tag.func_74764_b("itemCraftingRule1")) {
/*     */         
/* 363 */         rules[0] = tag.func_74771_c("itemCraftingRule1");
/*     */       }
/*     */       else {
/*     */         
/* 367 */         rules[0] = RuleEnum.ANY.Action;
/*     */       } 
/*     */       
/* 370 */       if (tag.func_74764_b("itemCraftingRule2")) {
/*     */         
/* 372 */         rules[1] = tag.func_74771_c("itemCraftingRule2");
/*     */       }
/*     */       else {
/*     */         
/* 376 */         rules[1] = RuleEnum.ANY.Action;
/*     */       } 
/*     */       
/* 379 */       if (tag.func_74764_b("itemCraftingRule3"))
/*     */       {
/* 381 */         rules[2] = tag.func_74771_c("itemCraftingRule3");
/*     */       }
/*     */       else
/*     */       {
/* 385 */         rules[2] = RuleEnum.ANY.Action;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 390 */       rules[0] = RuleEnum.ANY.Action;
/* 391 */       rules[1] = RuleEnum.ANY.Action;
/* 392 */       rules[2] = RuleEnum.ANY.Action;
/*     */     } 
/*     */     
/* 395 */     return rules;
/*     */   }
/*     */ 
/*     */   
/*     */   private void damageHammer() {
/* 400 */     this.anvilItemStacks[0].func_77964_b(this.anvilItemStacks[0].func_77960_j() + 1);
/* 401 */     if (this.anvilItemStacks[0].func_77960_j() == this.anvilItemStacks[0].func_77958_k()) {
/* 402 */       this.anvilItemStacks[0] = null;
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canBeWorked() {
/* 407 */     return (isTemperatureWorkable(1).booleanValue() && this.anvilItemStacks[0] != null && (this.anvilItemStacks[1]
/* 408 */       .func_77960_j() == 0 || this.anvilItemStacks[1].func_77973_b().func_77614_k()) && 
/* 409 */       getAnvilType() >= this.craftingReq && this.workedRecently == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionHeavyHammer() {
/* 414 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 416 */       if (canBeWorked()) {
/*     */         
/* 418 */         this.workedRecently = 5;
/* 419 */         setItemCraftingValue(-9);
/* 420 */         updateRules(0, 1);
/* 421 */         damageHammer();
/*     */       } 
/*     */     } else {
/*     */       
/* 425 */       sendAnvilUsePacket(0);
/*     */     } 
/*     */   }
/*     */   public void actionLightHammer() {
/* 429 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 431 */       if (canBeWorked()) {
/*     */         
/* 433 */         this.workedRecently = 5;
/* 434 */         setItemCraftingValue(-3);
/* 435 */         updateRules(0, 1);
/* 436 */         damageHammer();
/*     */       } 
/*     */     } else {
/*     */       
/* 440 */       sendAnvilUsePacket(-1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionDraw() {
/* 445 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 447 */       if (canBeWorked()) {
/*     */         
/* 449 */         this.workedRecently = 5;
/* 450 */         setItemCraftingValue(-15);
/* 451 */         updateRules(1, 1);
/* 452 */         damageHammer();
/*     */       } 
/*     */     } else {
/*     */       
/* 456 */       sendAnvilUsePacket(1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionHammer() {
/* 461 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 463 */       if (canBeWorked()) {
/*     */         
/* 465 */         this.workedRecently = 5;
/* 466 */         setItemCraftingValue(-6);
/* 467 */         updateRules(0, 1);
/* 468 */         damageHammer();
/*     */       } 
/*     */     } else {
/*     */       
/* 472 */       sendAnvilUsePacket(2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionPunch() {
/* 477 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 479 */       if (canBeWorked()) {
/*     */         
/* 481 */         this.workedRecently = 5;
/* 482 */         setItemCraftingValue(2);
/* 483 */         updateRules(3, 1);
/* 484 */         damageHammer();
/*     */       } 
/*     */     } else {
/*     */       
/* 488 */       sendAnvilUsePacket(3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionBend() {
/* 493 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 495 */       if (canBeWorked()) {
/*     */         
/* 497 */         this.workedRecently = 5;
/* 498 */         setItemCraftingValue(7);
/* 499 */         updateRules(4, 1);
/* 500 */         damageHammer();
/*     */       } 
/*     */     } else {
/*     */       
/* 504 */       sendAnvilUsePacket(4);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionUpset() {
/* 509 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 511 */       if (canBeWorked()) {
/*     */         
/* 513 */         this.workedRecently = 5;
/* 514 */         setItemCraftingValue(13);
/* 515 */         updateRules(5, 1);
/* 516 */         damageHammer();
/*     */       } 
/*     */     } else {
/*     */       
/* 520 */       sendAnvilUsePacket(5);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionShrink() {
/* 525 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 527 */       if (canBeWorked()) {
/*     */         
/* 529 */         this.workedRecently = 5;
/* 530 */         setItemCraftingValue(16);
/* 531 */         updateRules(6, 1);
/* 532 */         damageHammer();
/*     */       } 
/*     */     } else {
/*     */       
/* 536 */       sendAnvilUsePacket(6);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionWeld() {
/* 541 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 543 */       if (isTemperatureWeldable(2).booleanValue() && isTemperatureWeldable(3).booleanValue() && this.anvilItemStacks[0] != null && (this.anvilItemStacks[2]
/* 544 */         .func_77960_j() == 0 || this.anvilItemStacks[2].func_77973_b().func_77614_k()) && (this.anvilItemStacks[3]
/* 545 */         .func_77960_j() == 0 || this.anvilItemStacks[3].func_77973_b().func_77614_k()) && this.workedRecently == 0 && this.anvilItemStacks[4] == null) {
/*     */ 
/*     */         
/* 548 */         AnvilManager manager = AnvilManager.getInstance();
/*     */         
/* 550 */         AnvilRecipe recipe = new AnvilRecipe(this.anvilItemStacks[2], this.anvilItemStacks[3], "", 0, (this.anvilItemStacks[6] != null), this.anvilTier, null);
/*     */ 
/*     */ 
/*     */         
/* 554 */         AnvilRecipe recipe2 = new AnvilRecipe(this.anvilItemStacks[3], this.anvilItemStacks[2], "", 0, (this.anvilItemStacks[6] != null), this.anvilTier, null);
/*     */ 
/*     */ 
/*     */         
/* 558 */         ItemStack result = manager.findCompleteWeldRecipe(recipe);
/* 559 */         if (result == null) {
/* 560 */           result = manager.findCompleteWeldRecipe(recipe2);
/*     */         }
/* 562 */         if (result != null)
/*     */         {
/* 564 */           TFC_ItemHeat.setTemp(result, (TFC_ItemHeat.getTemp(this.anvilItemStacks[2]) + TFC_ItemHeat.getTemp(this.anvilItemStacks[3])) / 2.0F);
/* 565 */           if (result.field_77994_a <= 0)
/* 566 */             result.field_77994_a = 1; 
/* 567 */           func_70299_a(4, result);
/* 568 */           func_70299_a(2, (ItemStack)null);
/* 569 */           func_70299_a(3, (ItemStack)null);
/* 570 */           func_70298_a(6, 1);
/* 571 */           damageHammer();
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 577 */       sendAnvilUsePacket(7);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70305_f() {
/* 583 */     this.workRecipe = null;
/* 584 */     if (!this.field_145850_b.field_72995_K && this.anvilItemStacks[0] == null && this.anvilTier == AnvilReq.STONE.Tier) {
/*     */       
/* 586 */       ejectContents();
/* 587 */       this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d, this.field_145849_e, Block.func_149729_e(this.stonePair[0]), this.stonePair[1], 2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 594 */     if (this.anvilItemStacks[i] != null) {
/*     */       
/* 596 */       if ((this.anvilItemStacks[i]).field_77994_a <= j) {
/*     */         
/* 598 */         ItemStack itemstack = this.anvilItemStacks[i];
/* 599 */         this.anvilItemStacks[i] = null;
/* 600 */         return itemstack;
/*     */       } 
/* 602 */       ItemStack itemstack1 = this.anvilItemStacks[i].func_77979_a(j);
/* 603 */       if ((this.anvilItemStacks[i]).field_77994_a == 0)
/* 604 */         this.anvilItemStacks[i] = null; 
/* 605 */       return itemstack1;
/*     */     } 
/*     */     
/* 608 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 614 */     float f3 = 0.05F;
/*     */     
/* 616 */     Random rand = new Random();
/* 617 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 618 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 619 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 621 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 623 */       if (this.anvilItemStacks[i] != null) {
/*     */         
/* 625 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.anvilItemStacks[i]);
/*     */         
/* 627 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 628 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 629 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 630 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAnvilType() {
/* 637 */     return this.field_145847_g & 0x7;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 643 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 649 */     return "Anvil";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 655 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 661 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setItemCraftingValue(int i) {
/* 666 */     ItemStack input = this.anvilItemStacks[1];
/* 667 */     if (input != null) {
/*     */       
/* 669 */       NBTTagCompound tag = null;
/* 670 */       if (input.func_77942_o()) {
/*     */         
/* 672 */         tag = input.func_77978_p();
/* 673 */         if (tag.func_74764_b("itemCraftingValue"))
/*     */         {
/* 675 */           short craftingValue = tag.func_74765_d("itemCraftingValue");
/*     */           
/* 677 */           tag.func_74777_a("itemCraftingValue", (short)Math.max(0, craftingValue + i));
/*     */         
/*     */         }
/*     */         else
/*     */         {
/* 682 */           tag.func_74777_a("itemCraftingValue", (short)Math.max(0, i));
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 687 */         tag = new NBTTagCompound();
/*     */         
/* 689 */         tag.func_74777_a("itemCraftingValue", (short)Math.max(0, i));
/* 690 */         input.func_77982_d(tag);
/*     */       } 
/*     */       
/* 693 */       return true;
/*     */     } 
/*     */     
/* 696 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getItemCraftingValue() {
/* 701 */     ItemStack input = this.anvilItemStacks[1];
/* 702 */     if (input != null && input.func_77942_o() && input.func_77978_p().func_74764_b("itemCraftingValue"))
/*     */     {
/* 704 */       return input.func_77978_p().func_74765_d("itemCraftingValue");
/*     */     }
/*     */     
/* 707 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getItemCraftingValueNoSet(int i) {
/* 712 */     ItemStack input = this.anvilItemStacks[i];
/* 713 */     if (input != null && input.func_77942_o() && input.func_77978_p().func_74764_b("itemCraftingValue"))
/*     */     {
/* 715 */       return input.func_77978_p().func_74765_d("itemCraftingValue");
/*     */     }
/*     */     
/* 718 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean isTemperatureWeldable(int i) {
/* 723 */     HeatRegistry manager = HeatRegistry.getInstance();
/* 724 */     ItemStack is = this.anvilItemStacks[i];
/* 725 */     if (TFC_ItemHeat.hasTemp(is)) {
/*     */       
/* 727 */       HeatIndex index = manager.findMatchingIndex(is);
/* 728 */       if (index != null) {
/*     */         
/* 730 */         float temp = TFC_ItemHeat.getTemp(is);
/* 731 */         float weldTemp = index.meltTemp * 0.8F;
/* 732 */         if (temp < index.meltTemp && temp > weldTemp)
/*     */         {
/*     */           
/* 735 */           return Boolean.valueOf((!(is.func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal) || is.func_77960_j() == 0));
/*     */         }
/*     */       } 
/*     */     } 
/* 739 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean isTemperatureWorkable(int i) {
/* 744 */     HeatRegistry manager = HeatRegistry.getInstance();
/* 745 */     ItemStack is = this.anvilItemStacks[i];
/* 746 */     if (TFC_ItemHeat.hasTemp(is)) {
/*     */       
/* 748 */       HeatIndex index = manager.findMatchingIndex(is);
/* 749 */       if (index != null) {
/*     */         
/* 751 */         float temp = TFC_ItemHeat.getTemp(is);
/* 752 */         float workTemp = index.meltTemp * 0.6F;
/* 753 */         if (temp < index.meltTemp && temp > workTemp)
/*     */         {
/*     */           
/* 756 */           return Boolean.valueOf((!(is.func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal) || is.func_77960_j() == 0));
/*     */         }
/*     */       } 
/*     */     } 
/* 760 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 766 */     if (itemstack != null && itemstack.field_77994_a > func_70297_j_()) {
/*     */       
/* 768 */       if (itemstack.field_77994_a > func_70297_j_())
/* 769 */         itemstack.field_77994_a = func_70297_j_(); 
/* 770 */       if (itemstack.field_77994_a <= 0)
/* 771 */         itemstack = null; 
/*     */     } 
/* 773 */     this.anvilItemStacks[i] = itemstack;
/* 774 */     onSlotChanged(i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 780 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 791 */     return this.anvilItemStacks.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 797 */     return this.anvilItemStacks[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int var1) {
/* 803 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 809 */     super.func_145841_b(nbt);
/* 810 */     NBTTagList nbttaglist = new NBTTagList();
/* 811 */     for (int i = 0; i < this.anvilItemStacks.length; i++) {
/*     */       
/* 813 */       if (this.anvilItemStacks[i] != null) {
/*     */         
/* 815 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 816 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 817 */         this.anvilItemStacks[i].func_77955_b(nbttagcompound1);
/* 818 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 821 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/* 822 */     nbt.func_74768_a("Tier", this.anvilTier);
/* 823 */     nbt.func_74783_a("stonePair", this.stonePair);
/* 824 */     nbt.func_74778_a("plan", this.craftingPlan);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbttagcompound) {
/* 830 */     super.func_145839_a(nbttagcompound);
/* 831 */     NBTTagList nbttaglist = nbttagcompound.func_150295_c("Items", 10);
/* 832 */     this.anvilItemStacks = new ItemStack[func_70302_i_()];
/* 833 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 835 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 836 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 837 */       if (byte0 >= 0 && byte0 < this.anvilItemStacks.length)
/* 838 */         this.anvilItemStacks[byte0] = ItemStack.func_77949_a(nbttagcompound1); 
/*     */     } 
/* 840 */     this.anvilTier = nbttagcompound.func_74762_e("Tier");
/* 841 */     this.stonePair = nbttagcompound.func_74759_k("stonePair");
/* 842 */     this.craftingPlan = nbttagcompound.func_74779_i("plan");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPlan(String s) {
/* 847 */     if (this.field_145850_b.field_72995_K)
/* 848 */       sendPlanPacket(s); 
/* 849 */     this.craftingPlan = s;
/* 850 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 855 */     this.anvilTier = nbt.func_74762_e("AnvilTier");
/* 856 */     this.stonePair = nbt.func_74759_k("stonePair");
/* 857 */     if (nbt.func_74764_b("hammer"))
/*     */     {
/* 859 */       this.anvilItemStacks[0] = ItemStack.func_77949_a(nbt.func_74775_l("hammer"));
/*     */     }
/* 861 */     if (nbt.func_74764_b("input"))
/*     */     {
/* 863 */       this.anvilItemStacks[1] = ItemStack.func_77949_a(nbt.func_74775_l("input"));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 869 */     boolean weldFlag, soundFlag = false;
/* 870 */     switch (nbt.func_74762_e("action")) {
/*     */ 
/*     */       
/*     */       case -1:
/* 874 */         soundFlag = canBeWorked();
/* 875 */         actionLightHammer();
/*     */         break;
/*     */ 
/*     */       
/*     */       case 0:
/* 880 */         soundFlag = canBeWorked();
/* 881 */         actionHeavyHammer();
/*     */         break;
/*     */ 
/*     */       
/*     */       case 1:
/* 886 */         soundFlag = canBeWorked();
/* 887 */         actionDraw();
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/* 892 */         soundFlag = canBeWorked();
/* 893 */         actionHammer();
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/* 898 */         soundFlag = canBeWorked();
/* 899 */         actionPunch();
/*     */         break;
/*     */ 
/*     */       
/*     */       case 4:
/* 904 */         soundFlag = canBeWorked();
/* 905 */         actionBend();
/*     */         break;
/*     */ 
/*     */       
/*     */       case 5:
/* 910 */         soundFlag = canBeWorked();
/* 911 */         actionUpset();
/*     */         break;
/*     */ 
/*     */       
/*     */       case 6:
/* 916 */         soundFlag = canBeWorked();
/* 917 */         actionShrink();
/*     */         break;
/*     */ 
/*     */       
/*     */       case 7:
/* 922 */         weldFlag = (this.anvilItemStacks[4] == null);
/* 923 */         actionWeld();
/* 924 */         soundFlag = (weldFlag && this.anvilItemStacks[4] != null);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 8:
/* 929 */         if (!this.field_145850_b.field_72995_K) {
/*     */           
/* 931 */           setPlan(nbt.func_74779_i("plan"));
/* 932 */           this.lastWorker = this.field_145850_b.func_72924_a(nbt.func_74779_i("playername"));
/* 933 */           this.lastWorker.openGui(TerraFirmaCraft.instance, 21, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 934 */           updateRecipe();
/*     */         } 
/*     */         return;
/*     */     } 
/*     */     
/* 939 */     if (soundFlag) {
/* 940 */       this.field_145850_b.func_72908_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, "terrafirmacraft:anvil.metalimpact", 0.1F, 0.1F + this.field_145850_b.field_73012_v.nextFloat() / 4.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 946 */     nbt.func_74768_a("AnvilTier", this.anvilTier);
/* 947 */     nbt.func_74783_a("stonePair", this.stonePair);
/* 948 */     if (this.anvilItemStacks[0] != null) {
/*     */       
/* 950 */       NBTTagCompound hammerNBT = new NBTTagCompound();
/* 951 */       hammerNBT = this.anvilItemStacks[0].func_77955_b(hammerNBT);
/* 952 */       nbt.func_74782_a("hammer", (NBTBase)hammerNBT);
/*     */     } 
/* 954 */     if (this.anvilItemStacks[1] != null) {
/*     */       
/* 956 */       NBTTagCompound inputNBT = new NBTTagCompound();
/* 957 */       inputNBT = this.anvilItemStacks[1].func_77955_b(inputNBT);
/* 958 */       nbt.func_74782_a("input", (NBTBase)inputNBT);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private void sendAnvilUsePacket(int i) {
/* 965 */     NBTTagCompound nbt = new NBTTagCompound();
/* 966 */     nbt.func_74768_a("action", i);
/* 967 */     nbt.func_74778_a("playername", (PlayerManagerTFC.getInstance().getClientPlayer()).playerName);
/* 968 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private void sendPlanPacket(String plan) {
/* 974 */     NBTTagCompound nbt = new NBTTagCompound();
/* 975 */     nbt.func_74768_a("action", 8);
/* 976 */     nbt.func_74778_a("plan", plan);
/* 977 */     nbt.func_74778_a("playername", (PlayerManagerTFC.getInstance().getClientPlayer()).playerName);
/* 978 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */