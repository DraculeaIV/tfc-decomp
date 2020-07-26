/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Core.Vector3f;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Queue;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TELogPile
/*     */   extends TileEntity
/*     */   implements IInventory
/*     */ {
/*  35 */   public ItemStack[] storage = new ItemStack[4];
/*  36 */   private int logPileOpeners = 0;
/*  37 */   public int fireTimer = 100;
/*     */   public boolean isOnFire;
/*     */   private Queue<Vector3f> blocksToBeSetOnFire;
/*     */   
/*     */   public void addContents(int index, ItemStack is) {
/*  42 */     if (this.storage[index] == null)
/*     */     {
/*  44 */       this.storage[index] = is;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack takeLog(int slot) {
/*  50 */     if (this.storage[slot] == null) {
/*  51 */       return null;
/*     */     }
/*     */     
/*  54 */     ItemStack is = this.storage[slot].func_77946_l();
/*  55 */     is.field_77994_a = 1;
/*  56 */     (this.storage[slot]).field_77994_a--;
/*  57 */     if ((this.storage[slot]).field_77994_a == 0)
/*  58 */       this.storage[slot] = null; 
/*  59 */     if (getNumberOfLogs() == 0)
/*  60 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d, this.field_145849_e); 
/*  61 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearContents() {
/*  67 */     this.storage[0] = null;
/*  68 */     this.storage[1] = null;
/*  69 */     this.storage[2] = null;
/*  70 */     this.storage[3] = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {
/*  76 */     this.logPileOpeners--;
/*  77 */     if (this.logPileOpeners == 0 && this.storage[0] == null && this.storage[1] == null && this.storage[2] == null && this.storage[3] == null) {
/*     */       
/*  79 */       extinguishFire();
/*  80 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contentsMatch(int index, ItemStack is) {
/*  86 */     return (this.storage[index] != null && this.storage[index]
/*  87 */       .func_77973_b() == is.func_77973_b() && this.storage[index]
/*  88 */       .func_77960_j() == is.func_77960_j() && (this.storage[index]).field_77994_a < this.storage[index]
/*  89 */       .func_77976_d() && (this.storage[index]).field_77994_a + 1 <= 
/*  90 */       func_70297_j_());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumberOfLogs() {
/*  95 */     int[] count = new int[4];
/*  96 */     count[0] = (this.storage[0] != null) ? (this.storage[0]).field_77994_a : 0;
/*  97 */     count[1] = (this.storage[1] != null) ? (this.storage[1]).field_77994_a : 0;
/*  98 */     count[2] = (this.storage[2] != null) ? (this.storage[2]).field_77994_a : 0;
/*  99 */     count[3] = (this.storage[3] != null) ? (this.storage[3]).field_77994_a : 0;
/* 100 */     return count[0] + count[1] + count[2] + count[3];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int slot, int amount) {
/* 106 */     if (this.storage[slot] != null) {
/*     */ 
/*     */       
/* 109 */       if ((this.storage[slot]).field_77994_a <= amount) {
/*     */         
/* 111 */         ItemStack itemStack = this.storage[slot];
/* 112 */         this.storage[slot] = null;
/* 113 */         return itemStack;
/*     */       } 
/*     */       
/* 116 */       if ((this.storage[slot]).field_77994_a == 0) {
/* 117 */         this.storage[slot] = null;
/*     */       }
/* 119 */       ItemStack is = this.storage[slot].func_77979_a(amount);
/* 120 */       return is;
/*     */     } 
/*     */     
/* 123 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 128 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 130 */       if (this.storage[i] != null)
/*     */       {
/* 132 */         this.field_145850_b.func_72838_d((Entity)new EntityItem(this.field_145850_b, this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D, this.storage[i]));
/*     */       }
/*     */     } 
/* 135 */     extinguishFire();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 141 */     return 4;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 147 */     return "Log Pile";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 153 */     return this.storage.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int slot) {
/* 159 */     return this.storage[slot];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int slot) {
/* 165 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void injectContents(int index, int count) {
/* 170 */     if (this.storage[index] != null)
/*     */     {
/* 172 */       this.storage[index] = new ItemStack(this.storage[index].func_77973_b(), (this.storage[index]).field_77994_a + count, this.storage[index].func_77960_j());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 179 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {
/* 185 */     this.logPileOpeners++;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int slot, ItemStack is) {
/* 191 */     this.storage[slot] = is;
/* 192 */     if (is != null && is.field_77994_a > func_70297_j_()) {
/* 193 */       is.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUpdate() {
/* 199 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 205 */     super.func_145839_a(nbt);
/* 206 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 207 */     this.storage = new ItemStack[func_70302_i_()];
/* 208 */     this.isOnFire = nbt.func_74767_n("isOnFire");
/* 209 */     this.fireTimer = nbt.func_74762_e("fireTimer");
/* 210 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 212 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 213 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 214 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/* 215 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 222 */     super.func_145841_b(nbt);
/* 223 */     nbt.func_74757_a("isOnFire", this.isOnFire);
/* 224 */     nbt.func_74768_a("fireTimer", this.fireTimer);
/* 225 */     NBTTagList nbttaglist = new NBTTagList();
/* 226 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 228 */       if (this.storage[i] != null) {
/*     */         
/* 230 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 231 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 232 */         this.storage[i].func_77955_b(nbttagcompound1);
/* 233 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 236 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Packet func_145844_m() {
/* 242 */     NBTTagCompound nbt = new NBTTagCompound();
/* 243 */     func_145841_b(nbt);
/* 244 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
/* 250 */     func_145839_a(pkt.func_148857_g());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 257 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int slot, ItemStack is) {
/* 263 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void lightNeighbors() {
/* 268 */     if (!this.isOnFire) {
/*     */       return;
/*     */     }
/* 271 */     this.blocksToBeSetOnFire = new ArrayDeque<Vector3f>();
/*     */     
/* 273 */     Block block = this.field_145850_b.func_147439_a(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e);
/* 274 */     if (!TFC_Core.isValidCharcoalPitCover(block)) {
/* 275 */       this.blocksToBeSetOnFire.add(new Vector3f((this.field_145851_c + 1), this.field_145848_d, this.field_145849_e));
/*     */     }
/* 277 */     block = this.field_145850_b.func_147439_a(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e);
/* 278 */     if (!TFC_Core.isValidCharcoalPitCover(block)) {
/* 279 */       this.blocksToBeSetOnFire.add(new Vector3f((this.field_145851_c - 1), this.field_145848_d, this.field_145849_e));
/*     */     }
/* 281 */     block = this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1);
/* 282 */     if (!TFC_Core.isValidCharcoalPitCover(block)) {
/* 283 */       this.blocksToBeSetOnFire.add(new Vector3f(this.field_145851_c, this.field_145848_d, (this.field_145849_e + 1)));
/*     */     }
/* 285 */     block = this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1);
/* 286 */     if (!TFC_Core.isValidCharcoalPitCover(block)) {
/* 287 */       this.blocksToBeSetOnFire.add(new Vector3f(this.field_145851_c, this.field_145848_d, (this.field_145849_e - 1)));
/*     */     }
/* 289 */     block = this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/* 290 */     if (!TFC_Core.isValidCharcoalPitCover(block)) {
/* 291 */       this.blocksToBeSetOnFire.add(new Vector3f(this.field_145851_c, (this.field_145848_d + 1), this.field_145849_e));
/*     */     }
/* 293 */     block = this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e);
/* 294 */     if (!TFC_Core.isValidCharcoalPitCover(block)) {
/* 295 */       this.blocksToBeSetOnFire.add(new Vector3f(this.field_145851_c, (this.field_145848_d - 1), this.field_145849_e));
/*     */     }
/* 297 */     setOnFire(this.blocksToBeSetOnFire);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setOnFire(Queue<Vector3f> blocksOnFire) {
/* 302 */     while (blocksOnFire.size() > 0) {
/*     */       
/* 304 */       Vector3f blockOnFire = blocksOnFire.poll();
/* 305 */       if (this.field_145850_b.func_147439_a((int)blockOnFire.x, (int)blockOnFire.y, (int)blockOnFire.z) != Blocks.field_150480_ab) {
/*     */         
/* 307 */         this.field_145850_b.func_147449_b((int)blockOnFire.x, (int)blockOnFire.y, (int)blockOnFire.z, (Block)Blocks.field_150480_ab);
/* 308 */         this.field_145850_b.func_147471_g((int)blockOnFire.x, (int)blockOnFire.y, (int)blockOnFire.z);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void extinguishFire() {
/* 315 */     if (this.isOnFire) {
/*     */       
/* 317 */       if (this.field_145850_b.func_147439_a(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e) == Blocks.field_150480_ab) {
/*     */         
/* 319 */         this.field_145850_b.func_147468_f(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e);
/* 320 */         this.field_145850_b.func_147471_g(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e);
/*     */       } 
/* 322 */       if (this.field_145850_b.func_147439_a(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e) == Blocks.field_150480_ab) {
/*     */         
/* 324 */         this.field_145850_b.func_147468_f(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e);
/* 325 */         this.field_145850_b.func_147471_g(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e);
/*     */       } 
/* 327 */       if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1) == Blocks.field_150480_ab) {
/*     */         
/* 329 */         this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1);
/* 330 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1);
/*     */       } 
/* 332 */       if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1) == Blocks.field_150480_ab) {
/*     */         
/* 334 */         this.field_145850_b.func_147468_f(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e - 1);
/* 335 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1);
/*     */       } 
/* 337 */       if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e) == Blocks.field_150480_ab) {
/*     */         
/* 339 */         this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/* 340 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/*     */       } 
/* 342 */       if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e) == Blocks.field_150480_ab) {
/*     */         
/* 344 */         this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e);
/* 345 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e);
/*     */       } 
/* 347 */       this.isOnFire = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void activateCharcoal() {
/* 353 */     this.fireTimer = (int)TFC_Time.getTotalHours();
/* 354 */     this.isOnFire = true;
/*     */ 
/*     */     
/* 357 */     spreadFire(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e);
/* 358 */     spreadFire(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e);
/* 359 */     spreadFire(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/* 360 */     spreadFire(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e);
/* 361 */     spreadFire(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1);
/* 362 */     spreadFire(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1);
/*     */     
/* 364 */     lightNeighbors();
/*     */   }
/*     */ 
/*     */   
/*     */   private void spreadFire(int x, int y, int z) {
/* 369 */     if (this.field_145850_b.func_147439_a(x, y, z) == TFCBlocks.logPile && this.field_145850_b.func_147438_o(x, y, z) instanceof TELogPile) {
/*     */       
/* 371 */       TELogPile te = (TELogPile)this.field_145850_b.func_147438_o(x, y, z);
/* 372 */       if (!te.isOnFire)
/*     */       {
/* 374 */         te.activateCharcoal();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void createCharcoal(int x, int y, int z, boolean forceComplete) {
/* 381 */     if (this.field_145850_b.func_147439_a(x, y, z) == TFCBlocks.logPile) {
/*     */       
/* 383 */       TELogPile te = (TELogPile)this.field_145850_b.func_147438_o(x, y, z);
/* 384 */       if (te.isOnFire && (te.fireTimer + TFCOptions.charcoalPitBurnTime < (float)TFC_Time.getTotalHours() || forceComplete)) {
/*     */         
/* 386 */         int count = te.getNumberOfLogs();
/* 387 */         te.clearContents();
/* 388 */         float percent = (25 + this.field_145850_b.field_73012_v.nextInt(26));
/* 389 */         count = (int)(count * percent / 100.0F);
/* 390 */         this.field_145850_b.func_147465_d(x, y, z, TFCBlocks.charcoal, count, 2);
/*     */ 
/*     */         
/* 393 */         createCharcoal(x + 1, y, z, forceComplete); createCharcoal(x - 1, y, z, forceComplete);
/* 394 */         createCharcoal(x, y + 1, z, forceComplete); createCharcoal(x, y - 1, z, forceComplete);
/* 395 */         createCharcoal(x, y, z + 1, forceComplete); createCharcoal(x, y, z - 1, forceComplete);
/*     */         
/* 397 */         this.field_145850_b.func_147460_e(x, y, z, TFCBlocks.charcoal);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TELogPile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */