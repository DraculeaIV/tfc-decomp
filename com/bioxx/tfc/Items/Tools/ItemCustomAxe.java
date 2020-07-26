/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import com.google.common.collect.HashMultimap;
/*     */ import com.google.common.collect.Multimap;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemAxe;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemCustomAxe
/*     */   extends ItemAxe
/*     */   implements ISize, ICausesDamage
/*     */ {
/*     */   private float toolDamage;
/*     */   
/*     */   public ItemCustomAxe(Item.ToolMaterial e, float damage) {
/*  43 */     super(e);
/*  44 */     func_77656_e(e.func_77997_a());
/*  45 */     this.toolDamage = damage;
/*  46 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*  47 */     setNoRepair();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  53 */     String name = func_77658_a().replace("item.", "");
/*  54 */     name = name.replace("IgIn ", "");
/*  55 */     name = name.replace("IgEx ", "");
/*  56 */     name = name.replace("Sed ", "");
/*  57 */     name = name.replace("MM ", "");
/*  58 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:tools/" + name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon getIcon(ItemStack stack, int pass) {
/*  64 */     NBTTagCompound nbt = stack.func_77978_p();
/*  65 */     if (pass == 1 && nbt != null && nbt.func_74764_b("broken")) {
/*  66 */       return TFC_Textures.brokenItem;
/*     */     }
/*  68 */     return func_77618_c(stack.func_77960_j(), pass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/*  74 */     ItemTerra.addSizeInformation(is, arraylist);
/*  75 */     arraylist.add(EnumChatFormatting.AQUA + TFC_Core.translate(getDamageType().toString()));
/*  76 */     ItemTerraTool.addSmithingBonusInformation(is, arraylist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77639_j() {
/*  82 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77630_h(ItemStack itemStack) {
/*  88 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77651_p() {
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getContainerItem(ItemStack itemStack) {
/* 100 */     ItemStack container = itemStack.func_77946_l();
/* 101 */     container.func_77964_b(container.func_77960_j() + 1);
/* 102 */     container.field_77994_a = 1;
/* 103 */     return container;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasContainerItem(ItemStack stack) {
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRepairable() {
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 121 */     return EnumSize.LARGE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 127 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 133 */     return EnumWeight.MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumDamageType getDamageType() {
/* 139 */     return EnumDamageType.SLASHING;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Multimap getAttributeModifiers(ItemStack is) {
/* 145 */     HashMultimap hashMultimap = HashMultimap.create();
/* 146 */     hashMultimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Tool modifier", getWeaponDamage(is), 0));
/* 147 */     return (Multimap)hashMultimap;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getWeaponDamage(ItemStack is) {
/* 152 */     return Math.floor((this.toolDamage + this.toolDamage * AnvilManager.getDamageBuff(is)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDamage(ItemStack is) {
/* 158 */     return (int)Math.floor((func_77612_l() + func_77612_l() * AnvilManager.getDurabilityBuff(is)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDigSpeed(ItemStack stack, Block block, int meta) {
/* 164 */     float digSpeed = super.getDigSpeed(stack, block, meta);
/*     */     
/* 166 */     if (ForgeHooks.isToolEffective(stack, block, meta))
/*     */     {
/* 168 */       return digSpeed + digSpeed * AnvilManager.getDurabilityBuff(stack);
/*     */     }
/* 170 */     return digSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 176 */     return EnumItemReach.MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 182 */     boolean placed = false;
/* 183 */     int toolSlot = player.field_71071_by.field_70461_c;
/* 184 */     int nextSlot = (toolSlot == 0) ? 8 : (toolSlot + 1);
/* 185 */     ItemStack nextSlotStack = null;
/*     */     
/* 187 */     if (toolSlot < 8) {
/*     */       
/* 189 */       nextSlotStack = player.field_71071_by.func_70301_a(nextSlot);
/* 190 */       if (nextSlotStack != null) {
/*     */         
/* 192 */         Item item = nextSlotStack.func_77973_b();
/*     */         
/* 194 */         if (item instanceof ItemBlock) {
/*     */           
/* 196 */           int posX = x;
/* 197 */           int posY = y;
/* 198 */           int posZ = z;
/*     */           
/* 200 */           switch (side) {
/*     */             
/*     */             case 0:
/* 203 */               posY--;
/*     */               break;
/*     */             case 1:
/* 206 */               posY++;
/*     */               break;
/*     */             case 2:
/* 209 */               posZ--;
/*     */               break;
/*     */             case 3:
/* 212 */               posZ++;
/*     */               break;
/*     */             case 4:
/* 215 */               posX--;
/*     */               break;
/*     */             case 5:
/* 218 */               posX++;
/*     */               break;
/*     */           } 
/*     */           
/* 222 */           AxisAlignedBB blockBounds = AxisAlignedBB.func_72330_a(posX, posY, posZ, (posX + 1), (posY + 1), (posZ + 1));
/* 223 */           AxisAlignedBB playerBounds = player.field_70121_D;
/*     */           
/* 225 */           if (item instanceof ItemBlock) {
/*     */             
/* 227 */             Block blockToPlace = ((ItemBlock)item).field_150939_a;
/* 228 */             if (blockToPlace.func_149688_o().func_76230_c())
/*     */             {
/* 230 */               if (playerBounds.func_72326_a(blockBounds)) {
/* 231 */                 return false;
/*     */               }
/*     */             }
/*     */           } 
/* 235 */           int dmg = nextSlotStack.func_77960_j();
/* 236 */           int count = nextSlotStack.field_77994_a;
/*     */           
/* 238 */           placed = item.func_77648_a(nextSlotStack, player, world, x, y, z, side, hitX, hitY, hitZ);
/*     */           
/* 240 */           if (player.field_71075_bZ.field_75098_d) {
/*     */             
/* 242 */             nextSlotStack.func_77964_b(dmg);
/* 243 */             nextSlotStack.field_77994_a = count;
/*     */           } 
/* 245 */           if (nextSlotStack.field_77994_a < 1) {
/*     */             
/* 247 */             nextSlotStack = null;
/* 248 */             player.field_71071_by.func_70299_a(nextSlot, null);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 253 */     return placed;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemCustomAxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */