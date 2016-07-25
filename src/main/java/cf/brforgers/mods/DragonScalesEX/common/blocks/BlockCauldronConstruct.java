package cf.brforgers.mods.DragonScalesEX.common.blocks;

import cf.brforgers.mods.DragonScalesEX.common.blocks.tile.TileCauldronConstruct;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockCauldronConstruct extends BlockContainer {

	public BlockCauldronConstruct() {
		super(Material.IRON);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack){
		int dir = MathHelper.floor_double((double)((player.rotationYaw * 4F)/ 360F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(x,y,z,dir,0);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileCauldronConstruct();
	}
	
	@Override
	public int getRenderType(){
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	public boolean renderAsNormalBlock(){
		return false;
	}
}
