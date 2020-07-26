/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.TileEntities.TELogPile;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
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
/*     */ 
/*     */ 
/*     */ public class ItemLogs
/*     */   extends ItemTerra
/*     */ {
/*     */   private IIcon[] icons;
/*     */   
/*     */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/*     */     for (int i = 0; i < Global.WOOD_ALL.length; i++)
/*     */       list.add(new ItemStack(this, 1, i)); 
/*     */   }
/*     */   
/*     */   private boolean createPile(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, int l) {
/*     */     TELogPile te = null;
/*     */     if (world.func_147437_c(x, y, z) && isValid(world, x, y, z)) {
/*     */       world.func_147465_d(x, y, z, TFCBlocks.logPile, l, 3);
/*     */       te = (TELogPile)world.func_147438_o(x, y, z);
/*     */     } else {
/*     */       return false;
/*     */     } 
/*     */     if (te != null) {
/*     */       te.storage[0] = new ItemStack(this, 1, itemstack.func_77960_j());
/*     */       if (entityplayer.field_71075_bZ.field_75098_d) {
/*     */         te.storage[0] = new ItemStack(this, 4, itemstack.func_77960_j());
/*     */         te.storage[1] = new ItemStack(this, 4, itemstack.func_77960_j());
/*     */         te.storage[2] = new ItemStack(this, 4, itemstack.func_77960_j());
/*     */         te.storage[3] = new ItemStack(this, 4, itemstack.func_77960_j());
/*     */       } 
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   
/*     */   public ItemLogs() {
/* 115 */     this.icons = new IIcon[Global.WOOD_ALL.length]; func_77656_e(0); func_77627_a(true);
/*     */     func_77637_a(TFCTabs.TFC_MATERIALS);
/*     */     this.metaNames = (String[])Global.WOOD_ALL.clone();
/*     */     setWeight(EnumWeight.MEDIUM);
/* 119 */     setSize(EnumSize.MEDIUM); } public void func_94581_a(IIconRegister registerer) { for (int i = 0; i < Global.WOOD_ALL.length; i++) {
/* 120 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:wood/" + Global.WOOD_ALL[i] + " Log");
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 128 */     if (!world.field_72995_K) {
/*     */       
/* 130 */       if (entityplayer.func_70093_af() && (world.func_147439_a(x, y, z) != TFCBlocks.logPile || (side != 1 && side != 0))) {
/*     */         
/* 132 */         int dir = MathHelper.func_76128_c((entityplayer.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 133 */         if (side == 0) {
/* 134 */           y--;
/* 135 */         } else if (side == 1) {
/* 136 */           y++;
/* 137 */         } else if (side == 2) {
/* 138 */           z--;
/* 139 */         } else if (side == 3) {
/* 140 */           z++;
/* 141 */         } else if (side == 4) {
/* 142 */           x--;
/* 143 */         } else if (side == 5) {
/* 144 */           x++;
/* 145 */         }  if (world.func_147472_a(TFCBlocks.logPile, x, y, z, false, side, (Entity)entityplayer, itemstack) && 
/* 146 */           createPile(itemstack, entityplayer, world, x, y, z, side, dir)) {
/*     */           
/* 148 */           itemstack.field_77994_a--;
/* 149 */           playSound(world, x, y, z);
/*     */         } 
/* 151 */         return true;
/*     */       } 
/* 153 */       if (world.func_147439_a(x, y, z) == TFCBlocks.logPile) {
/*     */         
/* 155 */         TELogPile te = (TELogPile)world.func_147438_o(x, y, z);
/* 156 */         if (te != null)
/*     */         {
/* 158 */           if (te.storage[0] != null && te.contentsMatch(0, itemstack)) {
/* 159 */             te.injectContents(0, 1);
/* 160 */           } else if (te.storage[0] == null) {
/* 161 */             te.addContents(0, new ItemStack(this, 1, itemstack.func_77960_j()));
/* 162 */           } else if (te.storage[1] != null && te.contentsMatch(1, itemstack)) {
/* 163 */             te.injectContents(1, 1);
/* 164 */           } else if (te.storage[1] == null) {
/* 165 */             te.addContents(1, new ItemStack(this, 1, itemstack.func_77960_j()));
/* 166 */           } else if (te.storage[2] != null && te.contentsMatch(2, itemstack)) {
/* 167 */             te.injectContents(2, 1);
/* 168 */           } else if (te.storage[2] == null) {
/* 169 */             te.addContents(2, new ItemStack(this, 1, itemstack.func_77960_j()));
/* 170 */           } else if (te.storage[3] != null && te.contentsMatch(3, itemstack)) {
/* 171 */             te.injectContents(3, 1);
/* 172 */           } else if (te.storage[3] == null) {
/* 173 */             te.addContents(3, new ItemStack(this, 1, itemstack.func_77960_j()));
/*     */           } else {
/*     */             
/* 176 */             int dir = MathHelper.func_76128_c((entityplayer.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 177 */             if (side == 0) {
/* 178 */               y--;
/* 179 */             } else if (side == 1) {
/* 180 */               y++;
/* 181 */             } else if (side == 2) {
/* 182 */               z--;
/* 183 */             } else if (side == 3) {
/* 184 */               z++;
/* 185 */             } else if (side == 4) {
/* 186 */               x--;
/* 187 */             } else if (side == 5) {
/* 188 */               x++;
/* 189 */             }  if (!createPile(itemstack, entityplayer, world, x, y, z, side, dir)) {
/* 190 */               return true;
/*     */             }
/*     */           } 
/*     */           
/* 194 */           playSound(world, x, y, z);
/* 195 */           itemstack.field_77994_a--;
/* 196 */           return true;
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 202 */         int m = itemstack.func_77960_j();
/* 203 */         Block block = (m > 15) ? TFCBlocks.woodVert2 : TFCBlocks.woodVert;
/*     */         
/* 205 */         if (side == 0 && block.func_149742_c(world, x, y - 1, z) && world.func_147472_a(TFCBlocks.woodVert, x, y - 1, z, false, side, null, itemstack)) {
/*     */           
/* 207 */           world.func_147465_d(x, y - 1, z, block, m, 2);
/* 208 */           itemstack.field_77994_a--;
/* 209 */           playSound(world, x, y, z);
/*     */         }
/* 211 */         else if (side == 1 && block.func_149742_c(world, x, y + 1, z) && world.func_147472_a(TFCBlocks.woodVert, x, y + 1, z, false, side, null, itemstack)) {
/*     */           
/* 213 */           world.func_147465_d(x, y + 1, z, block, m, 2);
/* 214 */           itemstack.field_77994_a--;
/* 215 */           playSound(world, x, y, z);
/*     */         }
/* 217 */         else if (side == 2 && block.func_149742_c(world, x, y, z - 1) && world.func_147472_a(TFCBlocks.woodVert, x, y, z - 1, false, side, null, itemstack)) {
/*     */           
/* 219 */           setSide(world, itemstack, m, side, x, y, z - 1);
/*     */         }
/* 221 */         else if (side == 3 && block.func_149742_c(world, x, y, z + 1) && world.func_147472_a(TFCBlocks.woodVert, x, y, z + 1, false, side, null, itemstack)) {
/*     */           
/* 223 */           setSide(world, itemstack, m, side, x, y, z + 1);
/*     */         }
/* 225 */         else if (side == 4 && block.func_149742_c(world, x - 1, y, z) && world.func_147472_a(TFCBlocks.woodVert, x - 1, y, z, false, side, null, itemstack)) {
/*     */           
/* 227 */           setSide(world, itemstack, m, side, x - 1, y, z);
/*     */         }
/* 229 */         else if (side == 5 && block.func_149742_c(world, x + 1, y, z) && world.func_147472_a(TFCBlocks.woodVert, x + 1, y, z, false, side, null, itemstack)) {
/*     */           
/* 231 */           setSide(world, itemstack, m, side, x + 1, y, z);
/*     */         } 
/* 233 */         return true;
/*     */       } 
/*     */     } 
/* 236 */     return false;
/*     */   }
/*     */   public boolean isValid(World world, int i, int j, int k) { if (world.isSideSolid(i, j - 1, k, ForgeDirection.UP)) { TileEntity te = world.func_147438_o(i, j - 1, k); if (te instanceof TELogPile) { TELogPile lp = (TELogPile)te; if (lp.storage[0] == null || (lp.storage[0]).field_77994_a < 4)
/*     */           return false;  if (lp.storage[1] == null || (lp.storage[1]).field_77994_a < 4)
/*     */           return false;  if (lp.storage[2] == null || (lp.storage[2]).field_77994_a < 4)
/*     */           return false;  if (lp.storage[3] == null || (lp.storage[3]).field_77994_a < 4)
/*     */           return false;  }  return true; }  return false; } public IIcon func_77617_a(int meta) { if (meta < this.icons.length)
/* 243 */       return this.icons[meta];  return this.icons[0]; } public void setSide(World world, ItemStack itemstack, int m, int side, int x, int y, int z) { int meta = m % 8;
/* 244 */     Block log = TFCBlocks.woodHoriz;
/* 245 */     switch (m / 8) {
/*     */       case 1:
/* 247 */         log = TFCBlocks.woodHoriz2;
/*     */         break;
/*     */       case 2:
/* 250 */         log = TFCBlocks.woodHoriz3;
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 257 */     if (side == 2 || side == 3) {
/* 258 */       world.func_147465_d(x, y, z, log, meta, 2);
/* 259 */       itemstack.field_77994_a--;
/* 260 */       playSound(world, x, y, z);
/*     */     }
/* 262 */     else if (side == 4 || side == 5) {
/* 263 */       world.func_147465_d(x, y, z, log, meta | 0x8, 2);
/* 264 */       itemstack.field_77994_a--;
/* 265 */       playSound(world, x, y, z);
/*     */     }  }
/*     */ 
/*     */ 
/*     */   
/*     */   private void playSound(World world, int x, int y, int z) {
/* 271 */     world.func_72908_a(x + 0.5D, y + 0.5D, z + 0.5D, TFCBlocks.logNatural.field_149762_H.func_150496_b(), (TFCBlocks.logNatural.field_149762_H.func_150497_c() + 1.0F) / 2.0F, TFCBlocks.logNatural.field_149762_H.func_150494_d() * 0.8F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemLogs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */