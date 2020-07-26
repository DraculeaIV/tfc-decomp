/*     */ package com.bioxx.tfc.Entities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFalling;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityFallingBlockTFC
/*     */   extends Entity
/*     */   implements IEntityAdditionalSpawnData
/*     */ {
/*     */   private Block block;
/*     */   public int blockMeta;
/*     */   public int aliveTimer;
/*     */   public boolean shouldDropItem;
/*     */   private boolean hurtEntities;
/*     */   public int maxDamage;
/*     */   public float damage;
/*     */   public NBTTagCompound tileEntityData;
/*     */   
/*     */   public EntityFallingBlockTFC(World world) {
/*  49 */     super(world);
/*  50 */     this.shouldDropItem = true;
/*  51 */     this.maxDamage = 2000;
/*  52 */     this.damage = 100.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityFallingBlockTFC(World world, double x, double y, double z, Block b) {
/*  57 */     this(world, x, y, z, b, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityFallingBlockTFC(World world, double x, double y, double z, Block b, int meta) {
/*  62 */     this(world);
/*  63 */     this.shouldDropItem = false;
/*  64 */     this.block = b;
/*  65 */     this.blockMeta = meta;
/*  66 */     this.field_70156_m = true;
/*  67 */     func_70105_a(0.98F, 0.98F);
/*  68 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  69 */     func_70107_b(x, y, z);
/*  70 */     this.field_70159_w = 0.0D;
/*  71 */     this.field_70181_x = 0.0D;
/*  72 */     this.field_70179_y = 0.0D;
/*  73 */     this.field_70169_q = x;
/*  74 */     this.field_70167_r = y;
/*  75 */     this.field_70166_s = z;
/*  76 */     this.hurtEntities = b instanceof com.bioxx.tfc.Blocks.Terrain.BlockCobble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  86 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/*  98 */     return !this.field_70128_L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 107 */     if (this.block == null)
/*     */       return; 
/* 109 */     if (this.block.func_149688_o() == Material.field_151579_a) {
/*     */       
/* 111 */       func_70106_y();
/*     */     }
/*     */     else {
/*     */       
/* 115 */       this.field_70169_q = this.field_70165_t;
/* 116 */       this.field_70167_r = this.field_70163_u;
/* 117 */       this.field_70166_s = this.field_70161_v;
/* 118 */       this.aliveTimer++;
/* 119 */       this.field_70181_x -= 0.03999999910593033D;
/* 120 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 121 */       this.field_70159_w *= 0.9800000190734863D;
/* 122 */       this.field_70181_x *= 0.9800000190734863D;
/* 123 */       this.field_70179_y *= 0.9800000190734863D;
/*     */       
/* 125 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 127 */         int i = MathHelper.func_76128_c(this.field_70165_t);
/* 128 */         int j = MathHelper.func_76128_c(this.field_70163_u);
/* 129 */         int k = MathHelper.func_76128_c(this.field_70161_v);
/*     */         
/* 131 */         if (this.aliveTimer == 1)
/*     */         {
/* 133 */           this.field_70170_p.func_147468_f(i, j, k);
/*     */         }
/*     */         
/* 136 */         if (this.field_70122_E) {
/*     */           
/* 138 */           if (canReplace(this.field_70170_p, i, j, k)) {
/*     */             
/* 140 */             this.field_70170_p.func_147468_f(i, j, k);
/*     */           }
/* 142 */           else if (this.field_70170_p.func_147439_a(i, j, k).func_149669_A() < 1.0D) {
/*     */             
/* 144 */             j++;
/*     */           } 
/* 146 */           if (canReplace(this.field_70170_p, i, j - 1, k)) {
/*     */ 
/*     */             
/* 149 */             this.field_70170_p.func_147468_f(i, j - 1, k);
/* 150 */             this.field_70122_E = false;
/*     */           } 
/*     */         } 
/*     */         
/* 154 */         if (this.field_70122_E) {
/*     */           
/* 156 */           this.field_70159_w *= 0.699999988079071D;
/* 157 */           this.field_70179_y *= 0.699999988079071D;
/* 158 */           this.field_70181_x *= -0.5D;
/*     */           
/* 160 */           if (this.field_70170_p.func_147439_a(i, j, k) != Blocks.field_150326_M) {
/*     */             
/* 162 */             func_70106_y();
/*     */ 
/*     */             
/* 165 */             if (canPlaceEntityOnSide(this.field_70170_p, this.block, i, j, k, true, 1, (Entity)null, (ItemStack)null) && !BlockFalling.func_149831_e(this.field_70170_p, i, j - 1, k)) {
/*     */ 
/*     */               
/* 168 */               if (this.tileEntityData != null && this.block instanceof net.minecraft.block.ITileEntityProvider) {
/*     */                 
/* 170 */                 TileEntity tileentity = this.field_70170_p.func_147438_o(i, j, k);
/*     */                 
/* 172 */                 if (tileentity != null)
/*     */                 {
/* 174 */                   NBTTagCompound nbttagcompound = new NBTTagCompound();
/* 175 */                   tileentity.func_145841_b(nbttagcompound);
/* 176 */                   Iterator<String> iterator = this.tileEntityData.func_150296_c().iterator();
/*     */                   
/* 178 */                   while (iterator.hasNext()) {
/*     */                     
/* 180 */                     String s = iterator.next();
/* 181 */                     NBTBase nbtbase = this.tileEntityData.func_74781_a(s);
/*     */                     
/* 183 */                     if (!"x".equals(s) && !"y".equals(s) && !"z".equals(s))
/*     */                     {
/* 185 */                       nbttagcompound.func_74782_a(s, nbtbase.func_74737_b());
/*     */                     }
/*     */                   } 
/*     */                   
/* 189 */                   tileentity.func_145839_a(nbttagcompound);
/* 190 */                   tileentity.func_70296_d();
/*     */                 }
/*     */               
/*     */               } 
/* 194 */             } else if (this.shouldDropItem) {
/*     */               
/* 196 */               func_70099_a(new ItemStack(this.block, 1, this.block.func_149692_a(this.blockMeta)), 0.0F);
/*     */             }
/*     */           
/*     */           } 
/* 200 */         } else if ((this.aliveTimer > 100 && !this.field_70170_p.field_72995_K && (j < 1 || j > 256)) || this.aliveTimer > 600) {
/*     */           
/* 202 */           if (this.shouldDropItem)
/*     */           {
/* 204 */             func_70099_a(new ItemStack(this.block, 1, this.block.func_149692_a(this.blockMeta)), 0.0F);
/*     */           }
/*     */           
/* 207 */           func_70106_y();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canPlaceEntityOnSide(World world, Block fallingBlock, int x, int y, int z, boolean skipEntityCheck, int side, Entity thisEntity, ItemStack is) {
/* 215 */     AxisAlignedBB axisalignedbb = null;
/* 216 */     if (!skipEntityCheck) {
/*     */       
/* 218 */       axisalignedbb = fallingBlock.func_149668_a(world, x, y, z);
/* 219 */       if (!world.func_72917_a(axisalignedbb, thisEntity)) {
/* 220 */         return false;
/*     */       }
/*     */     } 
/* 223 */     Block block1 = world.func_147439_a(x, y, z);
/* 224 */     return (block1.func_149688_o() == Material.field_151594_q) ? true : canReplace(world, x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canReplace(World world, int x, int y, int z) {
/* 229 */     Block b = world.func_147439_a(x, y, z);
/* 230 */     if (canDestroy(b) && (b.isAir((IBlockAccess)world, x, y, z) || (
/* 231 */       !b.func_149662_c() && !b.func_149686_d() && !this.field_70170_p.isSideSolid(x, y, z, ForgeDirection.UP))))
/* 232 */       return TFC_Core.setBlockWithDrops(this.field_70170_p, x, y, z, getBlock(), this.blockMeta); 
/* 233 */     if (b instanceof com.bioxx.tfc.Blocks.Terrain.BlockOre && TFCOptions.enableCaveInsDestroyOre)
/* 234 */       return world.func_147468_f(x, y, z); 
/* 235 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canDestroy(Block b) {
/* 240 */     return (b != TFCBlocks.charcoal && b != TFCBlocks.molten);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float fallDistance) {
/* 249 */     if (this.hurtEntities) {
/*     */       
/* 251 */       int height = MathHelper.func_76123_f(fallDistance - 1.0F);
/*     */       
/* 253 */       if (height > 0) {
/*     */         
/* 255 */         ArrayList arraylist = new ArrayList(this.field_70170_p.func_72839_b(this, this.field_70121_D));
/* 256 */         DamageSource damagesource = (new DamageSource("caveIn")).func_76348_h().func_151518_m();
/* 257 */         Iterator<Entity> iterator = arraylist.iterator();
/*     */         
/* 259 */         while (iterator.hasNext()) {
/*     */           
/* 261 */           Entity entity = iterator.next();
/* 262 */           entity.func_70097_a(damagesource, Math.min(MathHelper.func_76141_d(height * this.damage), this.maxDamage));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound nbt) {
/* 274 */     nbt.func_74774_a("Tile", (byte)Block.func_149682_b(this.block));
/* 275 */     nbt.func_74768_a("TileID", Block.func_149682_b(this.block));
/* 276 */     nbt.func_74774_a("Data", (byte)this.blockMeta);
/* 277 */     nbt.func_74774_a("Time", (byte)this.aliveTimer);
/* 278 */     nbt.func_74757_a("DropItem", this.shouldDropItem);
/* 279 */     nbt.func_74757_a("HurtEntities", this.hurtEntities);
/* 280 */     nbt.func_74776_a("FallHurtAmount", this.damage);
/* 281 */     nbt.func_74768_a("FallHurtMax", this.maxDamage);
/*     */     
/* 283 */     if (this.tileEntityData != null)
/*     */     {
/* 285 */       nbt.func_74782_a("TileEntityData", (NBTBase)this.tileEntityData);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound nbt) {
/* 295 */     if (nbt.func_150297_b("TileID", 99)) {
/*     */       
/* 297 */       this.block = Block.func_149729_e(nbt.func_74762_e("TileID"));
/*     */     }
/*     */     else {
/*     */       
/* 301 */       this.block = Block.func_149729_e(nbt.func_74771_c("Tile") & 0xFF);
/*     */     } 
/*     */     
/* 304 */     this.blockMeta = nbt.func_74771_c("Data") & 0xFF;
/* 305 */     this.aliveTimer = nbt.func_74771_c("Time") & 0xFF;
/*     */     
/* 307 */     if (nbt.func_150297_b("HurtEntities", 99)) {
/*     */       
/* 309 */       this.hurtEntities = nbt.func_74767_n("HurtEntities");
/* 310 */       this.damage = nbt.func_74760_g("FallHurtAmount");
/* 311 */       this.maxDamage = nbt.func_74762_e("FallHurtMax");
/*     */     }
/* 313 */     else if (this.block instanceof com.bioxx.tfc.Blocks.Terrain.BlockCobble) {
/*     */       
/* 315 */       this.hurtEntities = true;
/*     */     } 
/*     */     
/* 318 */     if (nbt.func_150297_b("DropItem", 99))
/*     */     {
/* 320 */       this.shouldDropItem = nbt.func_74767_n("DropItem");
/*     */     }
/*     */     
/* 323 */     if (nbt.func_150297_b("TileEntityData", 10))
/*     */     {
/* 325 */       this.tileEntityData = nbt.func_74775_l("TileEntityData");
/*     */     }
/*     */     
/* 328 */     if (this.block.func_149688_o() == Material.field_151579_a)
/*     */     {
/* 330 */       this.block = (Block)Blocks.field_150354_m;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHurt(boolean hurt) {
/* 336 */     this.hurtEntities = hurt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_85029_a(CrashReportCategory category) {
/* 342 */     super.func_85029_a(category);
/* 343 */     category.func_71507_a("Immitating block ID", Integer.valueOf(Block.func_149682_b(this.block)));
/* 344 */     category.func_71507_a("Immitating block data", Integer.valueOf(this.blockMeta));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 351 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public World getWorld() {
/* 357 */     return this.field_70170_p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_90999_ad() {
/* 367 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/* 372 */     return this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeSpawnData(ByteBuf buffer) {
/* 377 */     buffer.writeInt(Block.func_149682_b(this.block));
/* 378 */     buffer.writeByte(this.blockMeta & 0xF);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf additionalData) {
/* 383 */     this.block = Block.func_149729_e(additionalData.readInt());
/* 384 */     this.blockMeta = additionalData.readByte();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\EntityFallingBlockTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */