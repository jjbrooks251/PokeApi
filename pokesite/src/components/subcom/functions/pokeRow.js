import React from 'react';

export function PokeRow(props) {
    return (
        <tbody>
            {props.data.map(element => {
                return (
                    <tr key={element.id}>
                        <td>{element.name}</td>
                    </tr>)
            })}
        </tbody>
    )
}