package version1;

import version1.channel.ActionChannel;
import version1.channel.BaseChannel;
import version1.channel.ConnectionChannel;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 16:30
 * @Description:
 */
public class OperationManager {
    private ConcurrentHashMap<String, NetworkFunction> nfs;

    public OperationManager(){
        nfs = new ConcurrentHashMap<String, NetworkFunction>();
    }

    public NetworkFunction obtainNetworkFunction(String host, int pid){
        System.out.println("find a NF");
        NetworkFunction nf;
        synchronized (this.nfs){
            String id = NetworkFunction.constructId(host , pid );
            if(nfs.containsKey(id)){
                nf = nfs.get(id);
            }else{
                nf = new NetworkFunction(host , pid);
                nfs.put(id , nf);
                System.out.println("set a NF successful");
            }
        }
        return nf;
    }

    public void channelConnected(BaseChannel channel){
        System.out.println("channel try to connect");
        NetworkFunction nf = obtainNetworkFunction(channel.getHost(),  channel.getPid());
        boolean connected = false;
        synchronized (nf){
            channel.setNetworkFunction(nf);
            if(channel instanceof ConnectionChannel){
                System.out.println("try to set a connection channel");
                nf.setConnectionChannel((ConnectionChannel) channel);
            }
            else if(channel instanceof ActionChannel){
                System.out.println("try to set a action channel");
                nf.setActionChannel((ActionChannel)channel);
            }

            if(nf.isFullyConnected()){
                connected = true;
            }
        }
        if(connected){
            System.out.println(NetworkFunction.constructId(nf.getHost(), nf.getPid())+"has already fully connected");
        }
        else{
            if(nf.hasConnectionChannel()){
                System.out.println("connection channel has connected");
            }
            else{
                System.out.println("action channel has connected");
            }
        }

    }
}



