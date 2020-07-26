/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Achievements;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEAnvil;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.google.common.collect.HashMultimap;
/*     */ import com.google.common.collect.Multimap;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemHammer
/*     */   extends ItemTerraTool
/*     */   implements ICausesDamage
/*     */ {
/*  40 */   private static final Set<Block> BLOCKS = Sets.newHashSet((Object[])new Block[0]);
/*     */   
/*     */   private float damageVsEntity;
/*     */   
/*     */   public ItemHammer(Item.ToolMaterial e, float damage) {
/*  45 */     super(0.0F, e, BLOCKS);
/*  46 */     this.damageVsEntity = damage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  52 */     Block id2 = player.field_70170_p.func_147439_a(x, y, z);
/*  53 */     int meta2 = player.field_70170_p.func_72805_g(x, y, z);
/*     */     
/*  55 */     if (id2 == TFCBlocks.stoneIgEx || id2 == TFCBlocks.stoneIgIn)
/*     */     {
/*  57 */       if (side == 1) {
/*     */         
/*  59 */         world.func_147449_b(x, y, z, TFCBlocks.anvil);
/*  60 */         player.func_71029_a((StatBase)TFC_Achievements.achAnvil);
/*  61 */         TEAnvil te = (TEAnvil)world.func_147438_o(x, y, z);
/*  62 */         if (te == null)
/*  63 */           world.func_147455_a(x, y, z, (TileEntity)new TEAnvil()); 
/*  64 */         if (te != null) {
/*     */           
/*  66 */           te.stonePair[0] = Block.func_149682_b(id2);
/*  67 */           te.stonePair[1] = meta2;
/*  68 */           te.func_145829_t();
/*     */         } 
/*     */         
/*  71 */         return true;
/*     */       } 
/*     */     }
/*  74 */     boolean placed = false;
/*  75 */     int toolSlot = player.field_71071_by.field_70461_c;
/*  76 */     int nextSlot = (toolSlot == 0) ? 8 : (toolSlot + 1);
/*  77 */     ItemStack nextSlotStack = null;
/*     */     
/*  79 */     if (toolSlot < 8) {
/*     */       
/*  81 */       nextSlotStack = player.field_71071_by.func_70301_a(nextSlot);
/*  82 */       if (nextSlotStack != null) {
/*     */         
/*  84 */         Item item = nextSlotStack.func_77973_b();
/*     */         
/*  86 */         if (item instanceof ItemBlock) {
/*     */           
/*  88 */           int posX = x;
/*  89 */           int posY = y;
/*  90 */           int posZ = z;
/*     */           
/*  92 */           switch (side) {
/*     */             
/*     */             case 0:
/*  95 */               posY--;
/*     */               break;
/*     */             case 1:
/*  98 */               posY++;
/*     */               break;
/*     */             case 2:
/* 101 */               posZ--;
/*     */               break;
/*     */             case 3:
/* 104 */               posZ++;
/*     */               break;
/*     */             case 4:
/* 107 */               posX--;
/*     */               break;
/*     */             case 5:
/* 110 */               posX++;
/*     */               break;
/*     */           } 
/*     */           
/* 114 */           AxisAlignedBB blockBounds = AxisAlignedBB.func_72330_a(posX, posY, posZ, (posX + 1), (posY + 1), (posZ + 1));
/* 115 */           AxisAlignedBB playerBounds = player.field_70121_D;
/*     */           
/* 117 */           if (item instanceof ItemBlock) {
/*     */             
/* 119 */             Block blockToPlace = ((ItemBlock)item).field_150939_a;
/* 120 */             if (blockToPlace.func_149688_o().func_76230_c())
/*     */             {
/* 122 */               if (playerBounds.func_72326_a(blockBounds)) {
/* 123 */                 return false;
/*     */               }
/*     */             }
/*     */           } 
/* 127 */           int dmg = nextSlotStack.func_77960_j();
/* 128 */           int count = nextSlotStack.field_77994_a;
/*     */           
/* 130 */           placed = item.func_77648_a(nextSlotStack, player, world, x, y, z, side, hitX, hitY, hitZ);
/*     */           
/* 132 */           if (player.field_71075_bZ.field_75098_d) {
/*     */             
/* 134 */             nextSlotStack.func_77964_b(dmg);
/* 135 */             nextSlotStack.field_77994_a = count;
/*     */           } 
/* 137 */           if (nextSlotStack.field_77994_a < 1) {
/*     */             
/* 139 */             nextSlotStack = null;
/* 140 */             player.field_71071_by.func_70299_a(nextSlot, null);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 145 */     return placed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 153 */     return EnumSize.SMALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumDamageType getDamageType() {
/* 159 */     return EnumDamageType.CRUSHING;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Multimap getAttributeModifiers(ItemStack is) {
/* 165 */     HashMultimap hashMultimap = HashMultimap.create();
/* 166 */     hashMultimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Tool modifier", getWeaponDamage(is), 0));
/* 167 */     return (Multimap)hashMultimap;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getWeaponDamage(ItemStack is) {
/* 172 */     return Math.floor((this.damageVsEntity + this.damageVsEntity * AnvilManager.getDamageBuff(is)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDamage(ItemStack is) {
/* 178 */     return (int)Math.floor((func_77612_l() + func_77612_l() * AnvilManager.getDurabilityBuff(is)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 184 */     return EnumItemReach.MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canHarvestBlock(Block block, ItemStack itemStack) {
/* 190 */     return checkBlock(block);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
/* 195 */     if (checkBlock(player.field_70170_p.func_147439_a(x, y, z))) {
/*     */       
/* 197 */       if (checkNeighbours(player.field_70170_p, x, y, z) || player.field_71075_bZ.field_75098_d) {
/* 198 */         return false;
/*     */       }
/*     */       
/* 201 */       itemstack.func_77972_a(itemstack.func_77958_k() / 30 + 100, (EntityLivingBase)player);
/* 202 */       TFC_Core.addPlayerExhaustion(player, 0.1F);
/*     */     } 
/*     */ 
/*     */     
/* 206 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDigSpeed(ItemStack stack, Block block, int meta) {
/* 211 */     float digSpeed = 1.0F;
/* 212 */     if (checkBlock(block)) {
/* 213 */       digSpeed += (stack.func_77958_k() / TFCOptions.hammerBreakSpeed);
/*     */     }
/* 215 */     return digSpeed + digSpeed * AnvilManager.getDurabilityBuff(stack);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkNeighbours(World world, int x, int y, int z) {
/* 220 */     return (!checkNeighbourBlock(world.func_147439_a(x + 1, y, z)) && 
/* 221 */       !checkNeighbourBlock(world.func_147439_a(x - 1, y, z)) && 
/* 222 */       !checkNeighbourBlock(world.func_147439_a(x, y + 1, z)) && 
/* 223 */       !checkNeighbourBlock(world.func_147439_a(x, y - 1, z)) && 
/* 224 */       !checkNeighbourBlock(world.func_147439_a(x, y, z + 1)) && 
/* 225 */       !checkNeighbourBlock(world.func_147439_a(x, y, z - 1)));
/*     */   }
/*     */   
/*     */   private boolean checkBlock(Block block) {
/* 229 */     String checkBlockName = block.func_149739_a().toLowerCase();
/* 230 */     return (block instanceof com.bioxx.tfc.Blocks.Terrain.BlockSmooth || checkBlockName.contains("brick") || checkBlockName.contains("smooth") || checkBlockName.contains("glass"));
/*     */   }
/*     */   private boolean checkNeighbourBlock(Block block) {
/* 233 */     return (block instanceof com.bioxx.tfc.Blocks.Terrain.BlockStone || block instanceof com.bioxx.tfc.Blocks.Terrain.BlockOre);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */