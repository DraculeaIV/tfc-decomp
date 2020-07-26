/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemCustomShovel
/*     */   extends ItemTerraTool
/*     */ {
/*  23 */   private static final Set<Block> BLOCKS_EFFECTIVE_AGAINST = Sets.newHashSet((Object[])new Block[] { (Block)Blocks.field_150349_c, Blocks.field_150346_d, (Block)Blocks.field_150354_m, Blocks.field_150351_n, Blocks.field_150433_aE, Blocks.field_150431_aC, Blocks.field_150435_aG, Blocks.field_150458_ak, Blocks.field_150425_aM, (Block)Blocks.field_150391_bh, TFCBlocks.dirt, TFCBlocks.dirt2, TFCBlocks.grass, TFCBlocks.grass2, TFCBlocks.clayGrass, TFCBlocks.clayGrass2, TFCBlocks.peatGrass, TFCBlocks.peat, TFCBlocks.clay, TFCBlocks.clay2 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemCustomShovel(Item.ToolMaterial par2EnumToolMaterial) {
/*  33 */     super(1.0F, par2EnumToolMaterial, BLOCKS_EFFECTIVE_AGAINST);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_150897_b(Block par1Block) {
/*  42 */     return (par1Block == Blocks.field_150431_aC) ? true : ((par1Block == Blocks.field_150433_aE));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  48 */     String name = func_77658_a().replace("item.", "");
/*  49 */     name = name.replace("IgIn ", "");
/*  50 */     name = name.replace("IgEx ", "");
/*  51 */     name = name.replace("Sed ", "");
/*  52 */     name = name.replace("MM ", "");
/*  53 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:tools/" + name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/*  59 */     return EnumItemReach.FAR;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  66 */     boolean placed = false;
/*  67 */     int toolSlot = player.field_71071_by.field_70461_c;
/*  68 */     int nextSlot = (toolSlot == 0) ? 8 : (toolSlot + 1);
/*  69 */     ItemStack nextSlotStack = null;
/*     */     
/*  71 */     if (toolSlot < 8) {
/*     */       
/*  73 */       nextSlotStack = player.field_71071_by.func_70301_a(nextSlot);
/*  74 */       if (nextSlotStack != null) {
/*     */         
/*  76 */         Item item = nextSlotStack.func_77973_b();
/*     */         
/*  78 */         if (item instanceof ItemBlock) {
/*     */           
/*  80 */           int posX = x;
/*  81 */           int posY = y;
/*  82 */           int posZ = z;
/*     */           
/*  84 */           switch (side) {
/*     */             
/*     */             case 0:
/*  87 */               posY--;
/*     */               break;
/*     */             case 1:
/*  90 */               posY++;
/*     */               break;
/*     */             case 2:
/*  93 */               posZ--;
/*     */               break;
/*     */             case 3:
/*  96 */               posZ++;
/*     */               break;
/*     */             case 4:
/*  99 */               posX--;
/*     */               break;
/*     */             case 5:
/* 102 */               posX++;
/*     */               break;
/*     */           } 
/*     */           
/* 106 */           AxisAlignedBB blockBounds = AxisAlignedBB.func_72330_a(posX, posY, posZ, (posX + 1), (posY + 1), (posZ + 1));
/* 107 */           AxisAlignedBB playerBounds = player.field_70121_D;
/*     */           
/* 109 */           if (item instanceof ItemBlock) {
/*     */             
/* 111 */             Block blockToPlace = ((ItemBlock)item).field_150939_a;
/* 112 */             if (blockToPlace.func_149688_o().func_76230_c())
/*     */             {
/* 114 */               if (playerBounds.func_72326_a(blockBounds)) {
/* 115 */                 return false;
/*     */               }
/*     */             }
/*     */           } 
/* 119 */           int dmg = nextSlotStack.func_77960_j();
/* 120 */           int count = nextSlotStack.field_77994_a;
/*     */           
/* 122 */           placed = item.func_77648_a(nextSlotStack, player, world, x, y, z, side, hitX, hitY, hitZ);
/*     */           
/* 124 */           if (player.field_71075_bZ.field_75098_d) {
/*     */             
/* 126 */             nextSlotStack.func_77964_b(dmg);
/* 127 */             nextSlotStack.field_77994_a = count;
/*     */           } 
/* 129 */           if (nextSlotStack.field_77994_a < 1) {
/*     */             
/* 131 */             nextSlotStack = null;
/* 132 */             player.field_71071_by.func_70299_a(nextSlot, null);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 137 */     return placed;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemCustomShovel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */