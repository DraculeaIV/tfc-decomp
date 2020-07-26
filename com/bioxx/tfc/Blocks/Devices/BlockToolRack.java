/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.TileEntities.TEToolRack;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
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
/*     */ public class BlockToolRack
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   protected String[] woodNames;
/*     */   
/*     */   public BlockToolRack() {
/*  39 */     super(Material.field_151575_d);
/*  40 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*  41 */     this.woodNames = Global.WOOD_ALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  47 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess bAccess, int x, int y, int z) {
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  65 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  71 */     return TFCBlocks.toolRackRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/*  77 */     if (!world.field_72995_K) {
/*     */       
/*  79 */       TileEntity te = world.func_147438_o(x, y, z);
/*  80 */       if (te instanceof TEToolRack) {
/*     */         
/*  82 */         TEToolRack tet = (TEToolRack)te;
/*  83 */         int dir = world.func_72805_g(x, y, z);
/*  84 */         if (dir == 0) {
/*     */           
/*  86 */           if (hitX < 0.5D && hitY > 0.5D) {
/*  87 */             handleArea(world, x, y, z, entityplayer, tet, 0, 0);
/*  88 */           } else if (hitX > 0.5D && hitY > 0.5D) {
/*  89 */             handleArea(world, x, y, z, entityplayer, tet, 1, 0);
/*  90 */           } else if (hitX < 0.5D) {
/*  91 */             handleArea(world, x, y, z, entityplayer, tet, 2, 0);
/*  92 */           } else if (hitX > 0.5D) {
/*  93 */             handleArea(world, x, y, z, entityplayer, tet, 3, 0);
/*     */           } 
/*  95 */         } else if (dir == 1) {
/*     */           
/*  97 */           if (hitZ < 0.5D && hitY > 0.5D) {
/*  98 */             handleArea(world, x, y, z, entityplayer, tet, 0, 1);
/*  99 */           } else if (hitZ > 0.5D && hitY > 0.5D) {
/* 100 */             handleArea(world, x, y, z, entityplayer, tet, 1, 1);
/* 101 */           } else if (hitZ < 0.5D) {
/* 102 */             handleArea(world, x, y, z, entityplayer, tet, 2, 1);
/* 103 */           } else if (hitZ > 0.5D) {
/* 104 */             handleArea(world, x, y, z, entityplayer, tet, 3, 1);
/*     */           } 
/* 106 */         } else if (dir == 2) {
/*     */           
/* 108 */           if (hitX < 0.5D && hitY > 0.5D) {
/* 109 */             handleArea(world, x, y, z, entityplayer, tet, 0, 2);
/* 110 */           } else if (hitX > 0.5D && hitY > 0.5D) {
/* 111 */             handleArea(world, x, y, z, entityplayer, tet, 1, 2);
/* 112 */           } else if (hitX < 0.5D) {
/* 113 */             handleArea(world, x, y, z, entityplayer, tet, 2, 2);
/* 114 */           } else if (hitX > 0.5D) {
/* 115 */             handleArea(world, x, y, z, entityplayer, tet, 3, 2);
/*     */           } 
/* 117 */         } else if (dir == 3) {
/*     */           
/* 119 */           if (hitZ < 0.5D && hitY > 0.5D) {
/* 120 */             handleArea(world, x, y, z, entityplayer, tet, 0, 3);
/* 121 */           } else if (hitZ > 0.5D && hitY > 0.5D) {
/* 122 */             handleArea(world, x, y, z, entityplayer, tet, 1, 3);
/* 123 */           } else if (hitZ < 0.5D) {
/* 124 */             handleArea(world, x, y, z, entityplayer, tet, 2, 3);
/* 125 */           } else if (hitZ > 0.5D) {
/* 126 */             handleArea(world, x, y, z, entityplayer, tet, 3, 3);
/*     */           } 
/* 128 */         }  world.func_147471_g(x, y, z);
/*     */         
/* 130 */         return true;
/*     */       } 
/*     */     } 
/* 133 */     return false;
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
/*     */   
/*     */   private void handleArea(World world, int x, int y, int z, EntityPlayer entityplayer, TEToolRack te, int slot, int dir) {
/* 148 */     boolean hasToolInHand = (entityplayer.func_71045_bC() != null && (entityplayer.func_71045_bC().func_77973_b() instanceof net.minecraft.item.ItemTool || entityplayer.func_71045_bC().func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemWeapon || entityplayer.func_71045_bC().func_77973_b() instanceof net.minecraft.item.ItemHoe || entityplayer.func_71045_bC().func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemProPick || entityplayer.func_71045_bC().func_77973_b() instanceof net.minecraft.item.ItemBow || entityplayer.func_71045_bC().func_77973_b() instanceof net.minecraft.item.ItemSword || entityplayer.func_71045_bC().func_77973_b() instanceof net.minecraft.item.ItemAxe || entityplayer.func_71045_bC().func_77973_b() instanceof net.minecraft.item.ItemSpade || entityplayer.func_71045_bC().func_77973_b() instanceof net.minecraft.item.ItemShears || entityplayer.func_71045_bC().func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemSpindle));
/* 149 */     if (te.storage[slot] == null && hasToolInHand) {
/*     */       
/* 151 */       te.storage[slot] = entityplayer.func_71045_bC().func_77946_l();
/* 152 */       entityplayer.field_71071_by.field_70462_a[entityplayer.field_71071_by.field_70461_c] = null;
/*     */     }
/* 154 */     else if (te.storage[slot] != null) {
/*     */       
/* 156 */       te.ejectItem(slot, dir);
/* 157 */       te.storage[slot] = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
/* 164 */     if (!world.field_72995_K) {
/*     */ 
/*     */       
/* 167 */       TileEntity te = world.func_147438_o(x, y, z);
/* 168 */       if (te instanceof TEToolRack) {
/*     */         
/* 170 */         TEToolRack rack = (TEToolRack)te;
/* 171 */         func_149642_a(world, x, y, z, new ItemStack(TFCBlocks.toolRack, 1, rack.woodType));
/*     */       } 
/*     */     } 
/* 174 */     return world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int x, int y, int z, int meta) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/* 188 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */     
/* 190 */     int damageValue = func_149643_k(world, x, y, z);
/* 191 */     ret.add(new ItemStack((Block)this, 1, damageValue));
/*     */     
/* 193 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta) {
/* 199 */     return (TileEntity)new TEToolRack();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess access, int x, int y, int z) {
/* 205 */     int dir = access.func_72805_g(x, y, z);
/* 206 */     if (dir == 0) {
/* 207 */       func_149676_a(0.0F, 0.0F, 0.85F, 1.0F, 1.0F, 1.0F);
/* 208 */     } else if (dir == 1) {
/* 209 */       func_149676_a(0.0F, 0.0F, 0.0F, 0.15F, 1.0F, 1.0F);
/* 210 */     } else if (dir == 2) {
/* 211 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.15F);
/* 212 */     } else if (dir == 3) {
/* 213 */       func_149676_a(0.85F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149633_g(World world, int x, int y, int z) {
/* 219 */     int dir = world.func_72805_g(x, y, z);
/* 220 */     if (dir == 0)
/* 221 */       return AxisAlignedBB.func_72330_a((x + 0.0F), (y + 0.0F), (z + 0.85F), (x + 1.0F), (y + 1.0F), (z + 1.0F)); 
/* 222 */     if (dir == 1)
/* 223 */       return AxisAlignedBB.func_72330_a((x + 0.0F), (y + 0.0F), (z + 0.0F), (x + 0.15F), (y + 1.0F), (z + 1.0F)); 
/* 224 */     if (dir == 2)
/* 225 */       return AxisAlignedBB.func_72330_a((x + 0.0F), (y + 0.0F), (z + 0.0F), (x + 1.0F), (y + 1.0F), (z + 0.15F)); 
/* 226 */     if (dir == 3) {
/* 227 */       return AxisAlignedBB.func_72330_a((x + 0.85F), (y + 0.0F), (z + 0.0F), (x + 1.0F), (y + 1.0F), (z + 1.0F));
/*     */     }
/* 229 */     return AxisAlignedBB.func_72330_a(x, y, z, (x + 1), (y + 1), (z + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 235 */     int dir = world.func_72805_g(x, y, z);
/*     */     
/* 237 */     if (dir == 0) {
/*     */       
/* 239 */       if (!world.func_147439_a(x, y, z + 1).isSideSolid((IBlockAccess)world, x, y, z + 1, ForgeDirection.NORTH)) {
/* 240 */         removedByPlayer(world, (EntityPlayer)null, x, y, z);
/*     */       }
/* 242 */     } else if (dir == 1) {
/*     */       
/* 244 */       if (!world.func_147439_a(x - 1, y, z).isSideSolid((IBlockAccess)world, x - 1, y, z, ForgeDirection.EAST)) {
/* 245 */         removedByPlayer(world, (EntityPlayer)null, x, y, z);
/*     */       }
/* 247 */     } else if (dir == 2) {
/*     */       
/* 249 */       if (!world.func_147439_a(x, y, z - 1).isSideSolid((IBlockAccess)world, x, y, z - 1, ForgeDirection.SOUTH)) {
/* 250 */         removedByPlayer(world, (EntityPlayer)null, x, y, z);
/*     */       }
/* 252 */     } else if (dir == 3) {
/*     */       
/* 254 */       if (!world.func_147439_a(x + 1, y, z).isSideSolid((IBlockAccess)world, x + 1, y, z, ForgeDirection.WEST)) {
/* 255 */         removedByPlayer(world, (EntityPlayer)null, x, y, z);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149660_a(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
/* 262 */     if (side == 4) return 3; 
/* 263 */     if (side == 5) return 1; 
/* 264 */     if (side == 2) return 0; 
/* 265 */     if (side == 3) return 2;
/*     */     
/* 267 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
/* 273 */     TileEntity te = world.func_147438_o(x, y, z);
/* 274 */     if (te instanceof TEToolRack) {
/*     */       
/* 276 */       TEToolRack rack = (TEToolRack)te;
/* 277 */       rack.woodType = (byte)is.func_77960_j();
/* 278 */       world.func_147471_g(x, y, z);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149707_d(World world, int x, int y, int z, int side) {
/* 285 */     if (func_149742_c(world, x, y, z)) {
/*     */       
/* 287 */       if (side == 5 && world.func_147439_a(x - 1, y, z).isSideSolid((IBlockAccess)world, x - 1, y, z, ForgeDirection.EAST))
/* 288 */         return true; 
/* 289 */       if (side == 4 && world.func_147439_a(x + 1, y, z).isSideSolid((IBlockAccess)world, x + 1, y, z, ForgeDirection.WEST))
/* 290 */         return true; 
/* 291 */       if (side == 2 && world.func_147439_a(x, y, z + 1).isSideSolid((IBlockAccess)world, x, y, z + 1, ForgeDirection.NORTH))
/* 292 */         return true; 
/* 293 */       if (side == 3 && world.func_147439_a(x, y, z - 1).isSideSolid((IBlockAccess)world, x, y, z - 1, ForgeDirection.SOUTH))
/* 294 */         return true; 
/*     */     } 
/* 296 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 306 */     for (int i = 0; i < this.woodNames.length; i++) {
/* 307 */       list.add(new ItemStack(item, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IIcon func_149673_e(IBlockAccess bAccess, int x, int y, int z, int side) {
/* 313 */     TEToolRack te = (TEToolRack)bAccess.func_147438_o(x, y, z);
/*     */     
/* 315 */     if (te.woodType > 15)
/* 316 */       return TFCBlocks.woodSupportV2.func_149691_a(side, te.woodType); 
/* 317 */     return TFCBlocks.woodSupportV.func_149691_a(side, te.woodType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 323 */     if (meta > 15)
/* 324 */       return TFCBlocks.woodSupportV2.func_149691_a(side, meta); 
/* 325 */     return TFCBlocks.woodSupportV.func_149691_a(side, meta);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/* 331 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess bAccess, int x, int y, int z, int side) {
/* 344 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149643_k(World world, int x, int y, int z) {
/* 353 */     TileEntity te = world.func_147438_o(x, y, z);
/* 354 */     if (te instanceof TEToolRack)
/* 355 */       return ((TEToolRack)te).woodType; 
/* 356 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockToolRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */