/**
 * Copyright 2016 EMC Corporation. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.emc.ecs.nfsclient.nfs.io;

import com.emc.ecs.nfsclient.nfs.nfs3.Nfs3;

/**
 * Nfs3 specialization of NfsFile. Almost all functionality is implemented in
 * the parent class.
 * 
 * @author seibed
 */
public class Nfs3File extends NfsFileBase<Nfs3, Nfs3File> {

    /**
     * The basic constructor.
     * 
     * @param nfs
     *            The supporting NFS client.
     * @param path
     *            The full path of the file, starting with the mount point.
     */
    public Nfs3File(Nfs3 nfs, String path) {
        super(nfs, path);
    }

    /**
     * The most efficient constructor if the parent file already exists.
     * 
     * @param parent
     *            The parent file, stored to reduce lookup overhead
     * @param child
     *            The short name of the file, starting from the parent path.
     */
    public Nfs3File(Nfs3File parent, String child) {
        super(parent, child);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emc.ecs.nfsclient.nfs.NfsFileBase#newChildFile(java.lang.String)
     */
    protected Nfs3File newChildFile(String childName) {
        return new Nfs3File(this, childName);
    }

}