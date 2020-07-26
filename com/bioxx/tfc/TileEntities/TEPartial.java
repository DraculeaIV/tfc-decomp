/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ public class TEPartial
/*     */   extends NetworkTileEntity {
/*   8 */   public short typeID = -1;
/*     */ 
/*     */   
/*     */   public byte metaID;
/*     */ 
/*     */   
/*     */   public byte material;
/*     */   
/*     */   public long extraData;
/*     */ 
/*     */   
/*     */   public boolean canUpdate() {
/*  20 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Material getMaterial() {
/*  25 */     switch (this.material) {
/*     */       
/*     */       case 1:
/*  28 */         return Material.field_151578_c;
/*     */       case 2:
/*  30 */         return Material.field_151575_d;
/*     */       case 3:
/*  32 */         return Material.field_151576_e;
/*     */       case 4:
/*  34 */         return Material.field_151573_f;
/*     */       case 5:
/*  36 */         return Material.field_151586_h;
/*     */       case 6:
/*  38 */         return Material.field_151587_i;
/*     */       case 7:
/*  40 */         return Material.field_151584_j;
/*     */       case 8:
/*  42 */         return Material.field_151585_k;
/*     */       case 9:
/*  44 */         return Material.field_151582_l;
/*     */       case 10:
/*  46 */         return Material.field_151583_m;
/*     */       case 11:
/*  48 */         return Material.field_151580_n;
/*     */       case 12:
/*  50 */         return Material.field_151581_o;
/*     */       case 13:
/*  52 */         return Material.field_151595_p;
/*     */       case 14:
/*  54 */         return Material.field_151594_q;
/*     */       case 15:
/*  56 */         return Material.field_151592_s;
/*     */       case 16:
/*  58 */         return Material.field_151591_t;
/*     */       case 17:
/*  60 */         return Material.field_151590_u;
/*     */       case 19:
/*  62 */         return Material.field_151588_w;
/*     */       case 20:
/*  64 */         return Material.field_151597_y;
/*     */       case 21:
/*  66 */         return Material.field_151596_z;
/*     */       case 22:
/*  68 */         return Material.field_151570_A;
/*     */       case 23:
/*  70 */         return Material.field_151571_B;
/*     */       case 24:
/*  72 */         return Material.field_151572_C;
/*     */       case 25:
/*  74 */         return Material.field_151566_D;
/*     */       case 26:
/*  76 */         return Material.field_151567_E;
/*     */       case 27:
/*  78 */         return Material.field_151568_F;
/*     */       case 28:
/*  80 */         return Material.field_151569_G;
/*     */       case 29:
/*  82 */         return Material.field_76233_E;
/*     */     } 
/*  84 */     return Material.field_151577_b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaterial(Material mat) {
/*  90 */     if (mat == Material.field_151578_c) { this.material = 1; }
/*  91 */     else if (mat == Material.field_151575_d)
/*     */     
/*  93 */     { this.material = 2; }
/*     */     
/*  95 */     else if (mat == Material.field_151576_e)
/*     */     
/*  97 */     { this.material = 3; }
/*     */     
/*  99 */     else if (mat == Material.field_151573_f)
/*     */     
/* 101 */     { this.material = 4; }
/*     */     
/* 103 */     else if (mat == Material.field_151586_h)
/*     */     
/* 105 */     { this.material = 5; }
/*     */     
/* 107 */     else if (mat == Material.field_151587_i)
/*     */     
/* 109 */     { this.material = 6; }
/*     */     
/* 111 */     else if (mat == Material.field_151584_j)
/*     */     
/* 113 */     { this.material = 7; }
/*     */     
/* 115 */     else if (mat == Material.field_151585_k)
/*     */     
/* 117 */     { this.material = 8; }
/*     */     
/* 119 */     else if (mat == Material.field_151582_l)
/*     */     
/* 121 */     { this.material = 9; }
/*     */     
/* 123 */     else if (mat == Material.field_151583_m)
/*     */     
/* 125 */     { this.material = 10; }
/*     */     
/* 127 */     else if (mat == Material.field_151580_n)
/*     */     
/* 129 */     { this.material = 11; }
/*     */     
/* 131 */     else if (mat == Material.field_151581_o)
/*     */     
/* 133 */     { this.material = 12; }
/*     */     
/* 135 */     else if (mat == Material.field_151595_p)
/*     */     
/* 137 */     { this.material = 13; }
/*     */     
/* 139 */     else if (mat == Material.field_151594_q)
/*     */     
/* 141 */     { this.material = 14; }
/*     */     
/* 143 */     else if (mat == Material.field_151592_s)
/*     */     
/* 145 */     { this.material = 15; }
/*     */     
/* 147 */     else if (mat == Material.field_151591_t)
/*     */     
/* 149 */     { this.material = 16; }
/*     */     
/* 151 */     else if (mat == Material.field_151590_u)
/*     */     
/* 153 */     { this.material = 17; }
/*     */     
/* 155 */     else if (mat == Material.field_151588_w)
/*     */     
/* 157 */     { this.material = 19; }
/*     */     
/* 159 */     else if (mat == Material.field_151597_y)
/*     */     
/* 161 */     { this.material = 20; }
/*     */     
/* 163 */     else if (mat == Material.field_151596_z)
/*     */     
/* 165 */     { this.material = 21; }
/*     */     
/* 167 */     else if (mat == Material.field_151570_A)
/*     */     
/* 169 */     { this.material = 22; }
/*     */     
/* 171 */     else if (mat == Material.field_151571_B)
/*     */     
/* 173 */     { this.material = 23; }
/*     */     
/* 175 */     else if (mat == Material.field_151572_C)
/*     */     
/* 177 */     { this.material = 24; }
/*     */     
/* 179 */     else if (mat == Material.field_151566_D)
/*     */     
/* 181 */     { this.material = 25; }
/*     */     
/* 183 */     else if (mat == Material.field_151567_E)
/*     */     
/* 185 */     { this.material = 26; }
/*     */     
/* 187 */     else if (mat == Material.field_151568_F)
/*     */     
/* 189 */     { this.material = 27; }
/*     */     
/* 191 */     else if (mat == Material.field_151569_G)
/*     */     
/* 193 */     { this.material = 28; }
/*     */     
/* 195 */     else if (mat == Material.field_76233_E)
/*     */     
/* 197 */     { this.material = 29; }
/*     */     
/* 199 */     else if (mat == Material.field_151577_b)
/*     */     
/* 201 */     { this.material = 0; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound par1NBTTagCompound) {
/* 211 */     super.func_145839_a(par1NBTTagCompound);
/* 212 */     this.metaID = par1NBTTagCompound.func_74771_c("metaID");
/* 213 */     this.typeID = par1NBTTagCompound.func_74765_d("typeID");
/* 214 */     this.material = par1NBTTagCompound.func_74771_c("material");
/* 215 */     this.extraData = par1NBTTagCompound.func_74763_f("extraData");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound par1NBTTagCompound) {
/* 224 */     super.func_145841_b(par1NBTTagCompound);
/* 225 */     par1NBTTagCompound.func_74777_a("typeID", this.typeID);
/* 226 */     par1NBTTagCompound.func_74774_a("metaID", this.metaID);
/* 227 */     par1NBTTagCompound.func_74774_a("material", this.material);
/* 228 */     par1NBTTagCompound.func_74772_a("extraData", this.extraData);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 234 */     this.metaID = nbt.func_74771_c("metaID");
/* 235 */     this.typeID = nbt.func_74765_d("typeID");
/* 236 */     this.material = nbt.func_74771_c("material");
/* 237 */     this.extraData = nbt.func_74763_f("extraData");
/* 238 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 244 */     this.extraData = nbt.func_74763_f("extraData");
/* 245 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void createDataNBT(NBTTagCompound nbt) {
/* 251 */     nbt.func_74772_a("extraData", this.extraData);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 257 */     nbt.func_74777_a("typeID", this.typeID);
/* 258 */     nbt.func_74774_a("metaID", this.metaID);
/* 259 */     nbt.func_74774_a("material", this.material);
/* 260 */     nbt.func_74772_a("extraData", this.extraData);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEPartial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */