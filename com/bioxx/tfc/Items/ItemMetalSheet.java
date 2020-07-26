/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Metal.MetalRegistry;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.TileEntities.TEMetalSheet;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemMetalSheet
/*     */   extends ItemTerra
/*     */   implements ISmeltable {
/*  22 */   protected int[][] sidesMap = new int[][] { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 } };
/*     */   
/*     */   public int metalID;
/*     */   
/*     */   private String metal;
/*     */   protected short metalAmount;
/*     */   private boolean smeltable = true;
/*     */   
/*     */   public ItemMetalSheet(int mID) {
/*  31 */     func_77656_e(0);
/*  32 */     func_77637_a(TFCTabs.TFC_MATERIALS);
/*  33 */     setFolder("ingots/");
/*  34 */     setWeight(EnumWeight.MEDIUM);
/*  35 */     setSize(EnumSize.MEDIUM);
/*  36 */     this.metalID = mID;
/*  37 */     this.metalAmount = 200;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerra setMetal(String m, int amt) {
/*  42 */     this.metal = m;
/*  43 */     this.metalAmount = (short)amt;
/*  44 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  50 */     boolean isSuccessful = false;
/*  51 */     if (!world.field_72995_K) {
/*     */ 
/*     */       
/*  54 */       if (itemstack.func_77942_o()) {
/*  55 */         return false;
/*     */       }
/*  57 */       TEMetalSheet te = null;
/*  58 */       int[] sides = this.sidesMap[side];
/*     */ 
/*     */       
/*  61 */       if (world.func_147439_a(x, y, z) == TFCBlocks.metalSheet && isValid(world, x, y, z)) {
/*     */         
/*  63 */         te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  64 */         switch (side) {
/*     */           
/*     */           case 0:
/*  67 */             if (!te.bottomExists()) {
/*     */               
/*  69 */               te.toggleBottom(true);
/*  70 */               isSuccessful = true;
/*     */             } 
/*     */             break;
/*     */           case 1:
/*  74 */             if (!te.topExists()) {
/*     */               
/*  76 */               te.toggleTop(true);
/*  77 */               isSuccessful = true;
/*     */             } 
/*     */             break;
/*     */           case 2:
/*  81 */             if (!te.northExists()) {
/*     */               
/*  83 */               te.toggleNorth(true);
/*  84 */               isSuccessful = true;
/*     */             } 
/*     */             break;
/*     */           case 3:
/*  88 */             if (!te.southExists()) {
/*     */               
/*  90 */               te.toggleSouth(true);
/*  91 */               isSuccessful = true;
/*     */             } 
/*     */             break;
/*     */           case 4:
/*  95 */             if (!te.eastExists()) {
/*     */               
/*  97 */               te.toggleEast(true);
/*  98 */               isSuccessful = true;
/*     */             } 
/*     */             break;
/*     */           case 5:
/* 102 */             if (!te.westExists()) {
/*     */               
/* 104 */               te.toggleWest(true);
/* 105 */               isSuccessful = true;
/*     */             } 
/*     */             break;
/*     */         } 
/*     */ 
/*     */         
/* 111 */         if (isSuccessful) {
/* 112 */           world.func_147471_g(x, y, z);
/*     */         }
/*     */       }
/* 115 */       else if (world.func_147439_a(x, y, z) != TFCBlocks.metalSheet && isValid(world, sides[0] + x, sides[1] + y, sides[2] + z)) {
/*     */         
/* 117 */         world.func_147449_b(sides[0] + x, sides[1] + y, sides[2] + z, TFCBlocks.metalSheet);
/* 118 */         te = (TEMetalSheet)world.func_147438_o(sides[0] + x, sides[1] + y, sides[2] + z);
/* 119 */         te.metalID = this.metalID;
/* 120 */         te.sheetStack = itemstack.func_77946_l();
/* 121 */         te.sheetStack.field_77994_a = 1;
/* 122 */         te.toggleBySide(flipSide(side), true);
/* 123 */         isSuccessful = true;
/*     */       }
/*     */       else {
/*     */         
/* 127 */         isSuccessful = false;
/*     */       } 
/*     */       
/* 130 */       if (isSuccessful)
/*     */       {
/* 132 */         itemstack.field_77994_a--;
/*     */       }
/*     */     } 
/*     */     
/* 136 */     return isSuccessful;
/*     */   }
/*     */   
/*     */   public int flipSide(int side) {
/* 140 */     switch (side) {
/*     */       case 0:
/* 142 */         return 1;
/* 143 */       case 1: return 0;
/* 144 */       case 2: return 3;
/* 145 */       case 3: return 2;
/* 146 */       case 4: return 5;
/* 147 */       case 5: return 4;
/*     */     } 
/* 149 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValid(World world, int i, int j, int k) {
/* 154 */     Block block = world.func_147439_a(i, j, k);
/* 155 */     if (block.isAir((IBlockAccess)world, i, j, k))
/* 156 */       return true; 
/* 157 */     if (block == TFCBlocks.metalSheet && world.func_147438_o(i, j, k) instanceof TEMetalSheet) {
/*     */       
/* 159 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(i, j, k);
/* 160 */       if (te.metalID == this.metalID)
/* 161 */         return true; 
/*     */     } 
/* 163 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Metal getMetalType(ItemStack is) {
/* 169 */     if (this.metal == null)
/*     */     {
/* 171 */       return MetalRegistry.instance.getMetalFromItem(this);
/*     */     }
/*     */ 
/*     */     
/* 175 */     return MetalRegistry.instance.getMetalFromString(this.metal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMetalReturnAmount(ItemStack is) {
/* 183 */     return this.metalAmount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSmeltable(ItemStack is) {
/* 190 */     return this.smeltable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISmeltable.EnumTier getSmeltTier(ItemStack is) {
/* 197 */     return ISmeltable.EnumTier.TierI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemStackLimit(ItemStack is) {
/* 204 */     if (is.func_77942_o()) {
/*     */       
/* 206 */       NBTTagCompound tag = is.func_77978_p();
/* 207 */       if (TFC_ItemHeat.hasTemp(is) || tag.func_74764_b("itemCraftingValue") || tag.func_74764_b("itemCraftingRule1"))
/*     */       {
/* 209 */         return 1;
/*     */       }
/*     */     } 
/*     */     
/* 213 */     return super.getItemStackLimit(is);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemMetalSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */