/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Metal.MetalRegistry;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.TileEntities.TEIngotPile;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemIngot
/*     */   extends ItemTerra
/*     */   implements ISmeltable
/*     */ {
/*  34 */   private EnumSize size = EnumSize.SMALL;
/*     */   
/*     */   private String metal;
/*     */   
/*     */   private short metalAmount;
/*     */   
/*     */   private boolean smeltable = true;
/*     */   
/*     */   public ItemIngot() {
/*  43 */     func_77637_a(TFCTabs.TFC_MATERIALS);
/*  44 */     setFolder("ingots/");
/*  45 */     this.metalAmount = 100;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemIngot(boolean canSmelt) {
/*  50 */     this();
/*  51 */     this.smeltable = canSmelt;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerra setMetal(String m, int amt) {
/*  56 */     this.metal = m;
/*  57 */     this.metalAmount = (short)amt;
/*  58 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  64 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + func_77658_a().replace("item.", "").replace("Weak ", "").replace("HC ", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/*  71 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  77 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/*  83 */     return EnumWeight.MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemIngot setSize(EnumSize s) {
/*  89 */     this.size = s;
/*  90 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addCreativeItems(List<ItemStack> list) {
/*  95 */     list.add(new ItemStack(this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean createPile(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, int l) {
/* 101 */     boolean fullStack = true;
/*     */     
/* 103 */     TEIngotPile te = null;
/*     */     
/* 105 */     if (world.func_147438_o(x, y, z) instanceof TEIngotPile && world.func_147439_a(x, y, z) == TFCBlocks.ingotPile) {
/*     */       
/* 107 */       te = (TEIngotPile)world.func_147438_o(x, y, z);
/* 108 */       if (te.contentsMatch(0, itemstack) && (te.func_70301_a(0)).field_77994_a < te.func_70297_j_()) {
/*     */         
/* 110 */         fullStack = false;
/* 111 */         te.injectContents(0, 1);
/*     */       } 
/*     */     } else {
/* 114 */       fullStack = true;
/*     */     } 
/* 116 */     if (fullStack && isPlaceable(itemstack)) {
/*     */       
/* 118 */       if (side == 0 && world.func_147437_c(x, y - 1, z) && isValid(world, x, y - 1, z)) {
/*     */         
/* 120 */         world.func_147465_d(x, y - 1, z, TFCBlocks.ingotPile, l, 2);
/* 121 */         if (world.field_72995_K) {
/* 122 */           world.func_147471_g(x, y - 1, z);
/*     */         }
/* 124 */         te = (TEIngotPile)world.func_147438_o(x, y - 1, z);
/*     */       }
/* 126 */       else if (side == 1 && world.func_147437_c(x, y + 1, z) && isValid(world, x, y + 1, z)) {
/*     */         
/* 128 */         world.func_147465_d(x, y + 1, z, TFCBlocks.ingotPile, l, 2);
/* 129 */         if (world.field_72995_K) {
/* 130 */           world.func_147471_g(x, y + 1, z);
/*     */         }
/* 132 */         te = (TEIngotPile)world.func_147438_o(x, y + 1, z);
/*     */       }
/* 134 */       else if (side == 2 && world.func_147437_c(x, y, z - 1) && isValid(world, x, y, z - 1)) {
/*     */         
/* 136 */         world.func_147465_d(x, y, z - 1, TFCBlocks.ingotPile, l, 2);
/* 137 */         if (world.field_72995_K) {
/* 138 */           world.func_147471_g(x, y, z - 1);
/*     */         }
/* 140 */         te = (TEIngotPile)world.func_147438_o(x, y, z - 1);
/*     */       }
/* 142 */       else if (side == 3 && world.func_147437_c(x, y, z + 1) && isValid(world, x, y, z + 1)) {
/*     */         
/* 144 */         world.func_147465_d(x, y, z + 1, TFCBlocks.ingotPile, l, 2);
/* 145 */         if (world.field_72995_K) {
/* 146 */           world.func_147471_g(x, y, z + 1);
/*     */         }
/* 148 */         te = (TEIngotPile)world.func_147438_o(x, y, z + 1);
/*     */       }
/* 150 */       else if (side == 4 && world.func_147437_c(x - 1, y, z) && isValid(world, x - 1, y, z)) {
/*     */         
/* 152 */         world.func_147465_d(x - 1, y, z, TFCBlocks.ingotPile, l, 2);
/* 153 */         if (world.field_72995_K) {
/* 154 */           world.func_147471_g(x - 1, y, z);
/*     */         }
/* 156 */         te = (TEIngotPile)world.func_147438_o(x - 1, y, z);
/*     */       }
/* 158 */       else if (side == 5 && world.func_147437_c(x + 1, y, z) && isValid(world, x + 1, y, z)) {
/*     */         
/* 160 */         world.func_147465_d(x + 1, y, z, TFCBlocks.ingotPile, l, 2);
/* 161 */         if (world.field_72995_K) {
/* 162 */           world.func_147471_g(x + 1, y, z);
/*     */         }
/* 164 */         te = (TEIngotPile)world.func_147438_o(x + 1, y, z);
/*     */       }
/*     */       else {
/*     */         
/* 168 */         return false;
/*     */       } 
/*     */       
/* 171 */       if (te != null) {
/*     */         
/* 173 */         te.storage[0] = new ItemStack(this, 1, 0);
/* 174 */         te.setType((MetalRegistry.instance.getMetalFromItem(this)).name);
/*     */         
/* 176 */         if (entityplayer.field_71075_bZ.field_75098_d)
/*     */         {
/* 178 */           te.storage[0] = new ItemStack(this, 32, 0);
/*     */         }
/*     */       } 
/*     */     } 
/* 182 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlaceable(ItemStack is) {
/* 187 */     Item id = is.func_77973_b();
/*     */     
/* 189 */     return (id != TFCItems.weakSteelIngot && id != TFCItems.highCarbonSteelIngot && id != TFCItems.highCarbonBlackSteelIngot && id != TFCItems.weakRedSteelIngot && id != TFCItems.weakBlueSteelIngot && id != TFCItems.highCarbonRedSteelIngot && id != TFCItems.highCarbonBlueSteelIngot);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 197 */     NBTTagCompound stackTagCompound = itemstack.func_77978_p();
/*     */     
/* 199 */     if (entityplayer.func_70093_af() && stackTagCompound == null && itemstack.func_77973_b().func_77658_a().indexOf("Double") == -1 && 
/* 200 */       isPlaceable(itemstack)) {
/*     */       
/* 202 */       int dir = MathHelper.func_76128_c((entityplayer.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 203 */       if (!world.field_72995_K && entityplayer.func_70093_af() && (world.func_147439_a(x, y, z) != TFCBlocks.ingotPile || (side != 1 && side != 0))) {
/*     */ 
/*     */         
/* 206 */         if (createPile(itemstack, entityplayer, world, x, y, z, side, dir))
/*     */         {
/*     */           
/* 209 */           itemstack.field_77994_a--;
/* 210 */           world.func_147452_c(x, y, z, TFCBlocks.ingotPile, 0, 0);
/* 211 */           return true;
/*     */         }
/*     */       
/*     */       }
/* 215 */       else if (world.func_147439_a(x, y, z) == TFCBlocks.ingotPile) {
/*     */         
/* 217 */         TEIngotPile te = (TEIngotPile)world.func_147438_o(x, y, z);
/*     */         
/* 219 */         if (te != null)
/*     */         {
/* 221 */           te.func_145838_q().func_149727_a(world, x, y, z, entityplayer, side, hitX, hitY, hitZ);
/* 222 */           if (te.storage[0] != null && te.contentsMatch(0, itemstack) && (te.storage[0]).field_77994_a < 64) {
/*     */             
/* 224 */             te.injectContents(0, 1);
/* 225 */             te.func_145829_t();
/*     */           } else {
/* 227 */             if (te.storage[0] != null && !te.contentsMatch(0, itemstack) && (te.storage[0]).field_77994_a < 64)
/*     */             {
/* 229 */               return false;
/*     */             }
/* 231 */             if (te.storage[0] == null) {
/*     */               
/* 233 */               te.addContents(0, new ItemStack(this, 1));
/*     */             }
/*     */             else {
/*     */               
/* 237 */               if (createPile(itemstack, entityplayer, world, x, y, z, side, dir)) {
/*     */                 
/* 239 */                 itemstack.field_77994_a--;
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 244 */                 world.func_147452_c(x, y, z, TFCBlocks.ingotPile, 0, 0);
/* 245 */                 te.func_145838_q().func_149727_a(world, x, y, z, entityplayer, side, hitX, hitY, hitZ);
/*     */               } 
/* 247 */               return true;
/*     */             } 
/*     */           } 
/* 250 */           itemstack.field_77994_a--;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 255 */           world.func_147452_c(x, y, z, TFCBlocks.ingotPile, 0, 0);
/* 256 */           return true;
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 262 */         int m = itemstack.func_77960_j();
/* 263 */         if (side == 1) {
/*     */           
/* 265 */           if (m >= 16) {
/* 266 */             world.func_147465_d(x, y + 1, z, TFCBlocks.ingotPile, m, 2);
/* 267 */             itemstack.field_77994_a--;
/*     */           } else {
/*     */             
/* 270 */             world.func_147465_d(x, y + 1, z, TFCBlocks.ingotPile, m, 2);
/* 271 */             itemstack.field_77994_a--;
/*     */           }
/*     */         
/* 274 */         } else if (side == 0 && world.func_147437_c(x, y - 1, z)) {
/*     */           
/* 276 */           if (m >= 16) {
/* 277 */             world.func_147465_d(x, y - 1, z, TFCBlocks.ingotPile, m, 2);
/* 278 */             itemstack.field_77994_a--;
/*     */           } else {
/*     */             
/* 281 */             world.func_147465_d(x, y - 1, z, TFCBlocks.ingotPile, m, 2);
/* 282 */             itemstack.field_77994_a--;
/*     */           }
/*     */         
/* 285 */         } else if (side == 2 && world.func_147437_c(x, y, z - 1)) {
/*     */           
/* 287 */           setSide(world, itemstack, m, dir, x, y, z, 0, 0, -1);
/*     */         }
/* 289 */         else if (side == 3 && world.func_147437_c(x, y, z + 1)) {
/*     */           
/* 291 */           setSide(world, itemstack, m, dir, x, y, z, 0, 0, 1);
/*     */         }
/* 293 */         else if (side == 4 && world.func_147437_c(x - 1, y, z)) {
/*     */           
/* 295 */           setSide(world, itemstack, m, dir, x, y, z, -1, 0, 0);
/*     */         }
/* 297 */         else if (side == 5 && world.func_147437_c(x + 1, y, z)) {
/*     */           
/* 299 */           setSide(world, itemstack, m, dir, x, y, z, 1, 0, 0);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 305 */         world.func_147452_c(x, y, z, TFCBlocks.ingotPile, 0, 0);
/* 306 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 310 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValid(World world, int i, int j, int k) {
/* 315 */     if (world.isSideSolid(i, j - 1, k, ForgeDirection.UP) || world.func_147439_a(i, j - 1, k) == TFCBlocks.ingotPile) {
/*     */       
/* 317 */       TileEntity te = world.func_147438_o(i, j - 1, k);
/*     */       
/* 319 */       if (te instanceof TEIngotPile) {
/*     */         
/* 321 */         TEIngotPile ip = (TEIngotPile)te;
/*     */         
/* 323 */         if (ip.storage[0] == null || (ip.storage[0]).field_77994_a < 64)
/*     */         {
/* 325 */           return false;
/*     */         }
/*     */       } 
/* 328 */       return true;
/*     */     } 
/* 330 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSide(World world, ItemStack itemstack, int m, int dir, int x, int y, int z, int i, int j, int k) {
/* 335 */     if (m < 8) {
/*     */       
/* 337 */       if (dir == 0 || dir == 2) {
/* 338 */         world.func_147465_d(x + i, y + j, z + k, TFCBlocks.ingotPile, m, 2);
/*     */       } else {
/* 340 */         world.func_147465_d(x + i, y + j, z + k, TFCBlocks.ingotPile, m | 0x8, 2);
/*     */       } 
/* 342 */       itemstack.field_77994_a--;
/*     */     }
/* 344 */     else if (m >= 16) {
/*     */       
/* 346 */       if (dir == 0 || dir == 2) {
/* 347 */         world.func_147465_d(x + i, y + j, z + k, TFCBlocks.ingotPile, m - 8, 2);
/*     */       } else {
/* 349 */         world.func_147465_d(x + i, y + j, z + k, TFCBlocks.ingotPile, m - 8 | 0x8, 2);
/*     */       } 
/* 351 */       itemstack.field_77994_a--;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Metal getMetalType(ItemStack is) {
/* 359 */     if (this.metal == null)
/*     */     {
/* 361 */       return MetalRegistry.instance.getMetalFromItem(this);
/*     */     }
/*     */ 
/*     */     
/* 365 */     return MetalRegistry.instance.getMetalFromString(this.metal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMetalReturnAmount(ItemStack is) {
/* 372 */     return this.metalAmount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSmeltable(ItemStack is) {
/* 379 */     return this.smeltable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ISmeltable.EnumTier getSmeltTier(ItemStack is) {
/* 385 */     return ISmeltable.EnumTier.TierI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemStackLimit(ItemStack is) {
/* 392 */     if (is.func_77942_o()) {
/*     */       
/* 394 */       NBTTagCompound tag = is.func_77978_p();
/* 395 */       if (TFC_ItemHeat.hasTemp(is) || tag.func_74764_b("itemCraftingValue") || tag.func_74764_b("itemCraftingRule1"))
/*     */       {
/* 397 */         return 1;
/*     */       }
/*     */     } 
/*     */     
/* 401 */     return super.getItemStackLimit(is);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemIngot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */