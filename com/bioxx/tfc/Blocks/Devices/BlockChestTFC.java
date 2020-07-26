/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEChest;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryLargeChest;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockChestTFC
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   private String[] woodNames;
/*     */   
/*     */   public BlockChestTFC() {
/*  42 */     super(Material.field_151575_d);
/*  43 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*  44 */     func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
/*  45 */     this.woodNames = Global.WOOD_ALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int var2) {
/*  51 */     return (TileEntity)new TEChest();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149643_k(World world, int x, int y, int z) {
/*  57 */     TileEntity te = world.func_147438_o(x, y, z);
/*  58 */     if (te instanceof TEChest)
/*  59 */       return ((TEChest)te).type; 
/*  60 */     return 0;
/*     */   }
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
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/*  74 */     return new ArrayList<ItemStack>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/*  80 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/*  88 */     for (int i = 0; i < this.woodNames.length; i++) {
/*  89 */       par3List.add(new ItemStack((Block)this, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149725_f(World world, int i, int j, int k, int meta) {
/*  95 */     if (!world.field_72995_K && world.func_82736_K().func_82766_b("doTileDrops")) {
/*     */       
/*  97 */       int damageValue = func_149643_k(world, i, j, k);
/*  98 */       EntityItem ei = new EntityItem(world, i, j, k, new ItemStack(TFCBlocks.chest, 1, damageValue));
/*  99 */       world.func_72838_d((Entity)ei);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
/* 106 */     if (world.field_72995_K)
/*     */     {
/* 108 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 112 */     IInventory iinventory = getInventory(world, x, y, z);
/*     */     
/* 114 */     if (iinventory != null) {
/* 115 */       player.openGui(TerraFirmaCraft.instance, 29, world, x, y, z);
/*     */     }
/* 117 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
/* 127 */     byte chestSide = 0;
/* 128 */     int facingDir = MathHelper.func_76128_c((player.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 129 */     int secFacingDir = MathHelper.func_76128_c((player.field_70177_z * 4.0F / 360.0F)) & 0x3;
/*     */     
/* 131 */     int facingN = 0;
/* 132 */     int facingE = 1;
/* 133 */     int facingS = 2;
/* 134 */     int facingW = 3;
/*     */     
/* 136 */     byte sideN = 2;
/* 137 */     byte sideS = 3;
/* 138 */     byte sideE = 5;
/* 139 */     byte sideW = 4;
/*     */     
/* 141 */     if (facingDir == 0) chestSide = 2; 
/* 142 */     if (facingDir == 1) chestSide = 5; 
/* 143 */     if (facingDir == 2) chestSide = 3; 
/* 144 */     if (facingDir == 3) chestSide = 4;
/*     */     
/* 146 */     ForgeDirection adjDirection = getAdjacentChestDirection((IBlockAccess)world, x, y, z, itemStack.func_77960_j());
/* 147 */     if (adjDirection == ForgeDirection.UNKNOWN) {
/*     */       
/* 149 */       world.func_72921_c(x, y, z, chestSide, 3);
/*     */     }
/*     */     else {
/*     */       
/* 153 */       switch (adjDirection) {
/*     */         
/*     */         case NORTH:
/*     */         case SOUTH:
/* 157 */           if (chestSide == 2 || chestSide == 3) {
/*     */             
/* 159 */             if (secFacingDir == 1 || secFacingDir == 0) chestSide = 5; 
/* 160 */             if (secFacingDir == 3 || secFacingDir == 2) chestSide = 4;
/*     */           
/*     */           } 
/*     */           break;
/*     */ 
/*     */         
/*     */         default:
/* 167 */           if (chestSide == 5 || chestSide == 4) {
/*     */             
/* 169 */             chestSide = 2;
/* 170 */             if (secFacingDir == 0 || secFacingDir == 3) chestSide = 2; 
/* 171 */             if (secFacingDir == 2 || secFacingDir == 1) chestSide = 3;
/*     */           
/*     */           } 
/*     */           break;
/*     */       } 
/*     */       
/* 177 */       world.func_72921_c(x, y, z, chestSide, 3);
/* 178 */       world.func_72921_c(x + adjDirection.offsetX, y, z + adjDirection.offsetZ, chestSide, 3);
/*     */     } 
/*     */     
/* 181 */     if (itemStack.func_82837_s()) {
/* 182 */       ((TEChest)world.func_147438_o(x, y, z)).func_145976_a(itemStack.func_82833_r());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 188 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 194 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 200 */     return TFCBlocks.chestRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess access, int x, int y, int z) {
/* 207 */     TEChest chest = (TEChest)access.func_147438_o(x, y, z);
/* 208 */     if (chest != null) {
/*     */       
/* 210 */       ForgeDirection adjDirection = getAdjacentChestDirection(access, x, y, z, chest.type);
/* 211 */       switch (adjDirection) {
/*     */         
/*     */         case NORTH:
/* 214 */           func_149676_a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
/*     */           return;
/*     */         case SOUTH:
/* 217 */           func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
/*     */           return;
/*     */         case EAST:
/* 220 */           func_149676_a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
/*     */           return;
/*     */         case WEST:
/* 223 */           func_149676_a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
/*     */           return;
/*     */       } 
/*     */       
/* 227 */       func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149726_b(World world, int x, int y, int z) {
/* 236 */     super.func_149726_b(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void unifyAdjacentChests(World world, int x, int y, int z) {}
/*     */ 
/*     */   
/*     */   private boolean isChestOfType(IBlockAccess world, int x, int y, int z, int type) {
/* 245 */     if (world.func_147439_a(x, y, z) == this) {
/*     */       
/* 247 */       TEChest chest = (TEChest)world.func_147438_o(x, y, z);
/* 248 */       return (chest.type == type);
/*     */     } 
/* 250 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private ForgeDirection getAdjacentChestDirection(IBlockAccess world, int x, int y, int z, int type) {
/* 255 */     ForgeDirection[] dirs = { ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.EAST, ForgeDirection.WEST };
/* 256 */     for (ForgeDirection dir : dirs) {
/*     */       
/* 258 */       if (isChestOfType(world, x + dir.offsetX, y, z + dir.offsetZ, type))
/* 259 */         return dir; 
/*     */     } 
/* 261 */     return ForgeDirection.UNKNOWN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149705_a(World world, int x, int y, int z, int side, ItemStack itemStack) {
/* 271 */     int type = itemStack.func_77960_j();
/*     */     
/* 273 */     ForgeDirection adjDirection = ForgeDirection.UNKNOWN;
/* 274 */     ForgeDirection[] dirs = { ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.EAST, ForgeDirection.WEST };
/* 275 */     for (ForgeDirection dir : dirs) {
/*     */       
/* 277 */       if (isChestOfType((IBlockAccess)world, x + dir.offsetX, y, z + dir.offsetZ, type)) {
/*     */         
/* 279 */         if (adjDirection != ForgeDirection.UNKNOWN) {
/* 280 */           return false;
/*     */         }
/* 282 */         adjDirection = dir;
/*     */       } 
/*     */     } 
/* 285 */     if (adjDirection == ForgeDirection.UNKNOWN)
/*     */     {
/*     */       
/* 288 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 293 */     ForgeDirection doubleDirection = getAdjacentChestDirection((IBlockAccess)world, x + adjDirection.offsetX, y, z + adjDirection.offsetZ, type);
/*     */     
/* 295 */     return (doubleDirection == ForgeDirection.UNKNOWN);
/*     */   }
/*     */ 
/*     */   
/*     */   public IInventory getInventory(World world, int x, int y, int z) {
/* 300 */     TEChest tEChest4, tEChest3, tEChest2, tEChest8, tEChest7, tEChest6, chest = (TEChest)world.func_147438_o(x, y, z);
/*     */     
/* 302 */     if (chest == null)
/*     */     {
/*     */       
/* 305 */       return null;
/*     */     }
/* 307 */     if (world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN))
/*     */     {
/*     */       
/* 310 */       return null;
/*     */     }
/*     */     
/* 313 */     ForgeDirection adjDirection = getAdjacentChestDirection((IBlockAccess)world, x, y, z, chest.type);
/* 314 */     if (adjDirection == ForgeDirection.UNKNOWN)
/*     */     {
/*     */       
/* 317 */       return (IInventory)chest;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 322 */     TEChest adjChest = (TEChest)world.func_147438_o(x + adjDirection.offsetX, y, z + adjDirection.offsetZ);
/* 323 */     switch (adjDirection)
/*     */     
/*     */     { case NORTH:
/* 326 */         tEChest4 = chest;
/* 327 */         tEChest8 = adjChest;
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
/* 343 */         return (IInventory)new InventoryLargeChest("container.chestDouble", (IInventory)tEChest4, (IInventory)tEChest8);case SOUTH: tEChest7 = chest; tEChest3 = adjChest; return (IInventory)new InventoryLargeChest("container.chestDouble", (IInventory)tEChest3, (IInventory)tEChest7);case EAST: tEChest6 = chest; tEChest2 = adjChest; return (IInventory)new InventoryLargeChest("container.chestDouble", (IInventory)tEChest2, (IInventory)tEChest6); }  TEChest tEChest1 = chest; TEChest tEChest5 = adjChest; return (IInventory)new InventoryLargeChest("container.chestDouble", (IInventory)tEChest1, (IInventory)tEChest5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister register) {
/* 352 */     this.field_149761_L = register.func_94245_a("planks_oak");
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockChestTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */