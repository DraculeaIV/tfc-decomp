/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Achievements;
/*     */ import com.bioxx.tfc.TileEntities.TEAnvil;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.google.common.collect.HashMultimap;
/*     */ import com.google.common.collect.Multimap;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemHammer extends ItemTerraTool implements ICausesDamage {
/*  27 */   private static final Set<Block> BLOCKS = Sets.newHashSet((Object[])new Block[0]);
/*     */   
/*     */   private float damageVsEntity;
/*     */   
/*     */   public ItemHammer(Item.ToolMaterial e, float damage) {
/*  32 */     super(0.0F, e, BLOCKS);
/*  33 */     this.damageVsEntity = damage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  39 */     Block id2 = player.field_70170_p.func_147439_a(x, y, z);
/*  40 */     int meta2 = player.field_70170_p.func_72805_g(x, y, z);
/*     */     
/*  42 */     if (id2 == TFCBlocks.stoneIgEx || id2 == TFCBlocks.stoneIgIn)
/*     */     {
/*  44 */       if (side == 1) {
/*     */         
/*  46 */         world.func_147449_b(x, y, z, TFCBlocks.anvil);
/*  47 */         player.func_71029_a((StatBase)TFC_Achievements.achAnvil);
/*  48 */         TEAnvil te = (TEAnvil)world.func_147438_o(x, y, z);
/*  49 */         if (te == null)
/*  50 */           world.func_147455_a(x, y, z, (TileEntity)new TEAnvil()); 
/*  51 */         if (te != null) {
/*     */           
/*  53 */           te.stonePair[0] = Block.func_149682_b(id2);
/*  54 */           te.stonePair[1] = meta2;
/*  55 */           te.func_145829_t();
/*     */         } 
/*     */         
/*  58 */         return true;
/*     */       } 
/*     */     }
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onBlockDestroyed(ItemStack stack, EntityPlayer player, World world, int i, int j, int k, int side, EntityLiving entity) {
/*  66 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  72 */     return EnumSize.SMALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumDamageType getDamageType() {
/*  78 */     return EnumDamageType.CRUSHING;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Multimap getAttributeModifiers(ItemStack is) {
/*  84 */     HashMultimap hashMultimap = HashMultimap.create();
/*  85 */     hashMultimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Tool modifier", getWeaponDamage(is), 0));
/*  86 */     return (Multimap)hashMultimap;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getWeaponDamage(ItemStack is) {
/*  91 */     return Math.floor((this.damageVsEntity + this.damageVsEntity * AnvilManager.getDamageBuff(is)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDamage(ItemStack is) {
/*  97 */     return (int)Math.floor((func_77612_l() + func_77612_l() * AnvilManager.getDurabilityBuff(is)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 103 */     return EnumItemReach.MEDIUM;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */